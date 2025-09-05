package cv.pn.processmanagement.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {

    M("M", "Masculino"),
    F("F", "Feminino");

    private final String code;
    private final String description;

    Gender(String code, String description) {
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
    public static Gender from(Object v) {
        if (v == null) throw new IllegalArgumentException("Campo 'sexo' é obrigatório (M ou F).");
        String s = v.toString().trim().toUpperCase();
        if (s.isEmpty()) throw new IllegalArgumentException("Campo 'sexo' é obrigatório (M ou F).");

        // aceita "M", "F", e também palavras iniciando em M/F (ex.: Masculino/Feminino)
        if (s.equals("M")) return M;
        if (s.equals("F")) return F;

        throw new IllegalArgumentException("Campo 'sexo' inválido. Use 'M' ou 'F'.");
    }

    @JsonValue
    public String toValue() {
        return name(); // serializa como "M" / "F"
    }
}
