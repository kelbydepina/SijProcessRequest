package cv.pn.processmanagement.enums;

public enum OrigemQueixa {
    PN("PN", "PN"),
    PJ("PJ", "PJ"),
    SIJ("SIJ", "SIJ");

    private final String code;
    private final String description;


    OrigemQueixa(String code, String description) {
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
