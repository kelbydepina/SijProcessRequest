package cv.pn.processmanagement.enums;

public enum ActorType {

    Arguido("ARGUIDO", "Arguido"),
    QEIXOSO("QEIXOSO", "Qeixoso"),
    DENUNCIANTE("DENUNCIANTE", "Denunciante"),
    DENUNCIADO("DENUNCIADO", "Denunciado"),
    TESTIMUNHA("TESTIMUNHA", "Testimunha"),
    VITIMA("VITIMA", "Vitima");

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
