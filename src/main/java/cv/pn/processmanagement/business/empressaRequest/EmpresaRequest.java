package cv.pn.processmanagement.business.empressaRequest;

import cv.pn.processmanagement.business.contatoRequest.ContactoRequest;
import cv.pn.processmanagement.business.enderecoRequest.EnderecoRequest;
import cv.pn.processmanagement.commons.CommonsAttributes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_fk")
    private EnderecoRequest endereco;

    // OneToMany Contactos
    @OneToMany(mappedBy = "empresaRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContactoRequest> contactos = new ArrayList<>();

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

    public List<ContactoRequest> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoRequest> contactos) {
        this.contactos = contactos;
    }

    public EnderecoRequest getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoRequest endereco) {
        this.endereco = endereco;
    }
}
