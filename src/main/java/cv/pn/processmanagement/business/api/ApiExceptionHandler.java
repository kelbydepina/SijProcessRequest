package cv.pn.processmanagement.business.api;


import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import javax.validation.ConstraintViolationException;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler {

    /*
      Regra 2 (valor inválido): quando um enum com @JsonCreator lança IllegalArgumentException
      o Spring normalmente embrulha em HttpMessageNotReadableException. Devolvemos a mensagem
      específica dos enums (ex.: "O campo 'sexo' deve ser..."). JSON malformado cai no fallback.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<APIResponse> handleParse(HttpMessageNotReadableException ex) {
        Throwable root = ex.getMostSpecificCause();
        if (root instanceof IllegalArgumentException) {
            String msg = root.getMessage();
            if (msg != null && !msg.isBlank()) {
                // Mensagem específica dos enums (Regra 2) OU "JASON INVALIDO" se vier padronizada do enum
                return badRequest(msg);
            }
            return badRequest("JASON INVALIDO");
        }

        // Se for outro tipo de erro de parse (JSON malformado, tipo incompatível etc.)
        String msg = mostSpecificMessage(ex);
        if (msg != null && msg.toLowerCase().contains("no enum constant")) {
            // Caso algum enum sem @JsonCreator ainda dispare esse texto
            return badRequest("Valores inválidos para enum. Preencha com os valores válidos definidos.");
        }

        return badRequest("JASON INVALIDO");
    }

    /**
     * Regra 1 (ausente): se @NotNull/@NotBlank(message="JASON INVALIDO") falhar para
     * nome/sexo/estadoCivil, devolvemos 400 "JASON INVALIDO".
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        boolean faltouCampoObrigatorioChave = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .anyMatch(this::isNomeSexoEstadoCivilObrigatorio);

        if (faltouCampoObrigatorioChave) {
            // Regra 1: ausente/null/vazio
            return badRequest("JASON INVALIDO");
        }

        // Demais validações: mantém seu comportamento original
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

    /**
     * Fallback para IllegalArgumentException fora do parse.
     * Se vier das regras dos enums, devolvemos a mensagem; caso contrário, mantém padrão.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<APIResponse> handleIllegalArgument(IllegalArgumentException ex) {
        String msg = ex.getMessage();
        if (msg != null && !msg.isBlank()) {
            return badRequest(msg);
        }
        return badRequest("JASON INVALIDO");
    }

    // ---- helpers ------------------------------------------------------------

    private boolean isNomeSexoEstadoCivilObrigatorio(FieldError fe) {
        // Só interessa quando a violação for de obrigatoriedade (NotNull/NotBlank etc.)
        String code = fe.getCode(); // e.g., "NotNull", "NotBlank"
        boolean obrigatorio = "NotNull".equals(code) || "NotBlank".equals(code);
        if (!obrigatorio) return false;

        String f = fe.getField().toLowerCase(); // ex.: "atores[0].pessoa.nome"
        return f.endsWith("nome") // PESSOA.NOME
                || f.endsWith("sexo") || f.endsWith("genero")
                || f.endsWith("estadocivil") || f.endsWith("estadocivel") || f.endsWith("estado_civil");
    }

    private ResponseEntity<APIResponse> badRequest(String msg) { return badRequest(List.of(msg)); }

    private ResponseEntity<APIResponse> badRequest(List<String> msgs) {
        APIResponse body = new APIResponse.buildAPIResponse()
                .setStatus(false)
                .setStatusText(MessageState.ERRO)
                // mantém sua estrutura original; se preferir lista simples, troque por .setDetails(msgs)
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
