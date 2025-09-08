package cv.pn.processmanagement.enums;




public enum DocumentType {
    BI("Bilhete de Identidade", "BI", 1),
    CNI("Cartão Nacional de Identificação", "CNI", 2),
    NIF("Número de Identificação Fiscal", "NIF", 3),
    TRE("Título de Residência Estrangeiro", "TRE", 4),
    PASS("Passaporte", "PASS", 5),
    CC("Carta de Condução", "CC", 6);

    private final String descricao;
    private final String codigo;
    private final int ordem;

    DocumentType(String descricao, String codigo, int ordem) {

        this.descricao = descricao;
        this.codigo = codigo;
        this.ordem = ordem;
    }


    public String getDescricao() {
        return descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getOrdem() {
        return ordem;
    }



}






