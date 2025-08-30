package cv.pn.processmanagement.business.api;

import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler {

    // JSON mal formatado / enums inválidos (pega os erros do Gender.from)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<APIResponse> handleParse(HttpMessageNotReadableException ex) {
        String msg = mostSpecificMessage(ex);
        if (msg != null && msg.contains("Campo 'sexo'")) {
            return badRequest(msg);
        }
        if (msg != null && msg.toLowerCase().contains("no enum constant")) {
            return badRequest("Valor inválido para enumeração.");
        }
        return badRequest("JSON inválido.");
    }

    // @Valid no @RequestBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> msgs = ex.getBindingResult().getFieldErrors().stream()
                .map(this::fieldMsg)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
        if (msgs.isEmpty()) msgs = List.of("Dados inválidos.");
        return badRequest(msgs);
    }

    // @Validated em params/path
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<APIResponse> handleConstraintViolation(ConstraintViolationException ex) {
        List<String> msgs = ex.getConstraintViolations().stream()
                .map(v -> v.getMessage() == null || v.getMessage().isBlank() ? "Parâmetro inválido." : v.getMessage())
                .distinct()
                .collect(Collectors.toList());
        return badRequest(msgs.isEmpty() ? List.of("Parâmetros inválidos.") : msgs);
    }

    // Mensagens limpas vindas do teu código (inclui Gender.from)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<APIResponse> handleIllegalArgument(IllegalArgumentException ex) {
        String msg = ex.getMessage();
        return badRequest(msg == null || msg.isBlank() ? "Requisição inválida." : msg);
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
