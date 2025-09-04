package cv.pn.processmanagement.enums;

public enum ActorsCharacteristics {

    CONHECIDO("CONHECIDO", "CONHECIDO"),
    DESCONHECIDO("DESCONHECIDO", "DESCONHECIDO"),
    ANONIMO("ANONIMO", "ANONIMO"),
    INDETERMINADO("INDETERMINADO", "INDETERMINADO");

    private final String code;
    private final String description;

    ActorsCharacteristics(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
