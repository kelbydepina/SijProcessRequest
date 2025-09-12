package cv.pn.processmanagement.business.empressaRequest;

import cv.pn.processmanagement.business.contatoRequest.ContactoDto;
import cv.pn.processmanagement.business.enderecoRequest.EnderecoDto;

import java.time.LocalDate;
import java.util.List;

public class EmpresaDto {

    private String registoComercial;
    private LocalDate dataConstituicao;
    private String estatutoBo;
    private String naturezaJuridica;
    private String capitalSocial;
    private String nrMatricula;
    private Integer nrNif;
    private String funcao;
    private String nomeRepresentante;
    private EnderecoDto endereco;
    private List<ContactoDto> contactos;

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

    public Integer getNrNif() {
        return nrNif;
    }

    public void setNrNif(Integer nrNif) {
        this.nrNif = nrNif;
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

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public List<ContactoDto> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoDto> contactos) {
        this.contactos = contactos;
    }
}
