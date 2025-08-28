package cv.pn.processmanagement.business.empressaRequest;

import cv.pn.processmanagement.commons.CommonsAttributes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "Empresa_Request")
public class EmpresaRequest extends CommonsAttributes {

    @Column(name = "commercial_registry", length = 100)
    private String registoComercial;

    @Column(name = "date_of_incorporation")
    private LocalDate dataConstituicao;

    @Column(name = "statute_bo", length = 100)
    private String estatutoBo;

    @Column(name = "legal_nature", length = 100)
    private String naturezaJuridica;

    @Column(name = "share_capital", length = 100)
    private String capitalSocial;

    @Column(name = "registration_number", length = 100)
    private String nrMatricula;

    @Column(name = "function", length = 100)
    private String funcao;

    @Column(name = "representative_name", length = 200)
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
