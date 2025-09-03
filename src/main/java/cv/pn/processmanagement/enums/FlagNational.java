package cv.pn.processmanagement.enums;

public enum FlagNational {
    Nacional( "NACIONAL", "Nacional"),
    ESTRANGEIRO("ESTRANGEIRO"," Estrangeiro");

    private final String code;
    private final String description;

    FlagNational(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
