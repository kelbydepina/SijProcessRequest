package cv.pn.processmanagement.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MaritalStatus {

    S("S", "Solteiro(a)"),
    C("C", "Casado(a)"),
    V("V", "Viúvo(a)"),
    U("U", "União de Factos"),
    D("D", "Divorciado(a)");
    private final String code;
    private final String description;

    MaritalStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @JsonCreator
    public static MaritalStatus from(String v) {
        if (v == null || v.isBlank()) return null;  // aceita vazio -> null
        try {
            return MaritalStatus.valueOf(v.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null; // inválido -> null, sem explodir
        }
    }

   /* @JsonCreator
    public static MaritalStatus from(Object raw) {
        final String MSG = "Campo 'estadoCivil' inválido. Use apenas: S, C, V, U, D.";
        if (raw == null) {
            throw new IllegalArgumentException("Campo 'estadoCivil' é obrigatório. " + MSG);
        }
        String s = raw.toString().trim().toUpperCase();
        if (s.isEmpty()) {
            throw new IllegalArgumentException("Campo 'estadoCivil' é obrigatório. " + MSG);
        }

        switch (s) {
            case "S": return S;
            case "C": return C;
            case "V": return V;
            case "U": return U;
            case "D": return D;
            default: throw new IllegalArgumentException(MSG);
        }
    }

    @JsonValue
    public String toValue() {
        // Serializa como o código (S/C/V/U/D)
        return this.code;
    }*/

    /*@JsonCreator
    public static MaritalStatus from(Object v) {
        if (v == null) throw new IllegalArgumentException("JASON INVALIDO"); // ausente/null
        String s = v.toString().trim().toUpperCase();
        if (s.isEmpty()) throw new IllegalArgumentException("JASON INVALIDO"); // presente porém vazio

        // aceita exatamente: S, C, V, U, D
        if (s.equals("S")) return S;
        if (s.equals("C")) return C;
        if (s.equals("V")) return V;
        if (s.equals("U")) return U;
        if (s.equals("D")) return D;

        // valor inválido → mensagem clara (Regra 2)
        throw new IllegalArgumentException("O campo 'estadoCivil' deve ser um dos valores válidos: S, C, V, U, D.");
    }

    @JsonValue
    public String toValue() { return name(); }

    /*@JsonCreator
    public static MaritalStatus from(Object v) {
        if (v == null) throw new IllegalArgumentException("Campo 'estadoCivil' é obrigatório (S,C,V,U,D ).");
        String s = v.toString().trim().toUpperCase();
        if (s.isEmpty()) throw new IllegalArgumentException("Campo 'estadoCivil' é obrigatório (S,C,V,U,D).");

        // aceita "M", "F", e também palavras iniciando em M/F (ex.: Masculino/Feminino)
        if (s.equals("S")) return S;
        if (s.equals("C")) return C;
        if (s.equals("V")) return V;
        if (s.equals("U")) return U;
        if (s.equals("D")) return D;

        throw new IllegalArgumentException("Campo 'sexo' inválido. Use 'M' ou 'F'.");
    }

    @JsonValue
    public String toValue() {
        return name();
    }*/
}
