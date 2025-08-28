package cv.pn.processmanagement.business.pessoaRequest;

import cv.pn.processmanagement.business.contatoRequest.ContactoDto;
import cv.pn.processmanagement.business.enderecoRequest.EnderecoDto;
import cv.pn.processmanagement.business.identificacao.IdentificacaoDto;
import cv.pn.processmanagement.enums.Gender;
import cv.pn.processmanagement.enums.MaritalStatus;

import java.time.LocalDate;
import java.util.List;

public class PessoaDto {

    private String nome;
    private String alcunha;
    private String flagNacional;
    private String nomeMae;
    private String nomePai;
    private Gender sexo;
    private MaritalStatus estadoCivil;
    private String nacionalidade;
    private Integer idNacionalidade;
    private String localTrabalho;
    private String profissao;
    private LocalDate dataNascimento;
    private String descricaoFisica;
    private EnderecoDto endereco;
    private List<IdentificacaoDto> identificacoes;
    private List<ContactoDto> contactos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlcunha() {
        return alcunha;
    }

    public void setAlcunha(String alcunha) {
        this.alcunha = alcunha;
    }

    public String getFlagNacional() {
        return flagNacional;
    }

    public void setFlagNacional(String flagNacional) {
        this.flagNacional = flagNacional;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public Gender getSexo() {
        return sexo;
    }

    public void setSexo(Gender sexo) {
        this.sexo = sexo;
    }

    public MaritalStatus getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(MaritalStatus estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Integer getIdNacionalidade() {
        return idNacionalidade;
    }

    public void setIdNacionalidade(Integer idNacionalidade) {
        this.idNacionalidade = idNacionalidade;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDescricaoFisica() {
        return descricaoFisica;
    }

    public void setDescricaoFisica(String descricaoFisica) {
        this.descricaoFisica = descricaoFisica;
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public List<IdentificacaoDto> getIdentificacoes() {
        return identificacoes;
    }

    public void setIdentificacoes(List<IdentificacaoDto> identificacoes) {
        this.identificacoes = identificacoes;
    }

    public List<ContactoDto> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoDto> contactos) {
        this.contactos = contactos;
    }
}
