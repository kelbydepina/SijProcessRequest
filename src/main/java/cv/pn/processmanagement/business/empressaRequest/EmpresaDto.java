package cv.pn.processmanagement.business.empressaRequest;

import java.time.LocalDate;

public class EmpresaDto {

    private String registoComercial;
    private LocalDate dataConstituicao;
    private String estatutoBo;
    private String naturezaJuridica;
    private String capitalSocial;
    private String nrMatricula;
    private String funcao;
    private String nomeRepresentante;

    public String getRegistoComercial() {
        return registoComercial;
    }

    public void setRegistoComercial(String registoComercial) {
        this.registoComercial = registoComercial;
    }

    public LocalDate getDataConstituicao() {
        return dataConstituicao;
    }

    public void setDataConstituicao(LocalDate dataConstituicao) {
        this.dataConstituicao = dataConstituicao;
    }

    public String getEstatutoBo() {
        return estatutoBo;
    }

    public void setEstatutoBo(String estatutoBo) {
        this.estatutoBo = estatutoBo;
    }

    public String getNaturezaJuridica() {
        return naturezaJuridica;
    }

    public void setNaturezaJuridica(String naturezaJuridica) {
        this.naturezaJuridica = naturezaJuridica;
    }

    public String getCapitalSocial() {
        return capitalSocial;
    }

    public void setCapitalSocial(String capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public String getNrMatricula() {
        return nrMatricula;
    }

    public void setNrMatricula(String nrMatricula) {
        this.nrMatricula = nrMatricula;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }
}
