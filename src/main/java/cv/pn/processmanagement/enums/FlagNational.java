package cv.pn.processmanagement.enums;

public enum FlagNational {
    NACIONAL( "NACIONAL", "NACIONAL"),
    ESTRANGEIRO("ESTRANGEIRO"," ESTRANGEIRO");

    private final String code;
    private final String description;

    FlagNational(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
