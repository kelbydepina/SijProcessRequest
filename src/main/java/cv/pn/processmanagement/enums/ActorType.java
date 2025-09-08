package cv.pn.processmanagement.enums;

public enum ActorType {

    ARGUIDO("ARGUIDO", "ARGUIDO"),
    QEIXOSO("QEIXOSO", "QEIXOSO"),
    DENUNCIANTE("DENUNCIANTE", "DENUNCIANTE"),
    DENUNCIADO("DENUNCIADO", "DENUNCIADO"),
    TESTIMUNHA("TESTIMUNHA", "TESTIMUNHA"),
    VITIMA("VITIMA", "VITIMA");

    private final String code;
    private final String description;


    ActorType(String code, String description) {
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
