package cv.pn.processmanagement.enums;

public enum TipoPrazoInvestigacao {
    DIA("DIA", "Dia"),
    MES("MES", "Mes"),
    TRIMESTRE("TRIMESTE", "Trimestre"),
    SIMESTRE("SIMESTRE", "Simestre");

    private final String code;
    private final String description;


    TipoPrazoInvestigacao(String code, String description) {
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
