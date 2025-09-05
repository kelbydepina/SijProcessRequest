package cv.pn.processmanagement.business.api;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler {

    // JSON mal formatado / enums inválidos
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<APIResponse> handleParse(HttpMessageNotReadableException ex) {
        Throwable root = NestedExceptionUtils.getMostSpecificCause(ex);
        String msg = resolveReadableMessage(root);
        return badRequest(msg);
    }

    // ... mantém os teus outros @ExceptionHandler (MethodArgumentNotValid, ConstraintViolation, IllegalArgument, etc.)

    // ========== helpers específicos p/ leitura JSON ==========
    private String resolveReadableMessage(Throwable root) {
        // Mensagem lançada dentro do @JsonCreator (ex.: MaritalStatus.from)
        if (root instanceof ValueInstantiationException) {
            Throwable cause = root.getCause();
            if (cause instanceof IllegalArgumentException) {
                // aqui vem exatamente o texto que tu lanças no enum (ex.: "Campo 'estadoCivil' inválido. Use: S,C,V,U,D.")
                return cause.getMessage();
            }
            return ((ValueInstantiationException) root).getOriginalMessage();
        }

        // Tipos/formatos errados (datas, horas, numbers, enums sem @JsonCreator)
        if (root instanceof InvalidFormatException) {
            InvalidFormatException e = (InvalidFormatException) root;

            String path = e.getPath().stream()
                    .map(JsonMappingException.Reference::getFieldName)
                    .filter(Objects::nonNull)
                    .collect(Collectors.joining("."));

            Class<?> target = e.getTargetType();
            if (target == java.time.LocalDate.class) {
                return "Campo '" + path + "' inválido. Use o formato 'yyyy-MM-dd'.";
            }
            if (target == java.time.LocalTime.class) {
                return "Campo '" + path + "' inválido. Use o formato 'HH:mm:ss'.";
            }
            if (target.isEnum()) {
                // para enums que não possuem @JsonCreator customizado
                return "Valor inválido para '" + path + "'.";
            }
            return "Campo '" + path + "' inválido. Valor: '" + e.getValue() + "'.";
        }

        // Qualquer IllegalArgumentException direta
        if (root instanceof IllegalArgumentException) {
            return root.getMessage();
        }

        // Fallback
        return "JSON inválido.";
    }

    // ---- helpers ------------------------------------------------------------
    private ResponseEntity<APIResponse> badRequest(String msg) { return badRequest(List.of(msg)); }
    private ResponseEntity<APIResponse> badRequest(List<String> msgs) {
        APIResponse body = new APIResponse.buildAPIResponse()
                .setStatus(false)
                .setStatusText(MessageState.ERRO)
                .setDetails(Collections.singletonList(msgs))
                .builder();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    private String fieldMsg(FieldError e) {
        return e.getDefaultMessage() != null && !e.getDefaultMessage().isBlank()
                ? e.getDefaultMessage()
                : e.getField() + " inválido.";
    }
    private String mostSpecificMessage(HttpMessageNotReadableException ex) {
        var root = ex.getMostSpecificCause();
        return root != null ? root.getMessage() : ex.getMessage();
    }
}
