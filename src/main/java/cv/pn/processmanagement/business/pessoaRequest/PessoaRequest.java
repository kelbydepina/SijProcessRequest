package cv.pn.processmanagement.business.pessoaRequest;


import cv.pn.processmanagement.business.contatoRequest.ContactoRequest;
import cv.pn.processmanagement.business.enderecoRequest.EnderecoRequest;
import cv.pn.processmanagement.business.identificacao.IdentificacaoRequest;
import cv.pn.processmanagement.commons.CommonsAttributes;
import cv.pn.processmanagement.enums.Gender;
import cv.pn.processmanagement.enums.MaritalStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Pessoa_Request")
public class PessoaRequest extends CommonsAttributes {


    // Usando o enum Gender para o campo sexo
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 1, nullable = false)
    private Gender sexo;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status", length = 1)
    private MaritalStatus estadoCivil;

    @Column(name = "name", length = 150, nullable = false)
    private String nome;

    @Column(name = "nickname", length = 200)
    private String alcunha;

    @Column(name = "mothers_name", length = 100)
    private String nomeMae;

    @Column(name = "fathers_name", length = 100)
    private String nomePai;

    @Column(name = "nationality", length = 100)
    private String nacionalidade;

    @Column(name = "id_nationality")
    private Long idNacionalidade;

    @Column(name = "work_place", length = 200)
    private String localTrabalho;

    @Column(name = "profession", length = 100)
    private String profissao;

    @Column(name = "date_of_birth")
    private LocalDate dataNascimento;

    @Column(name = "physical_description", columnDefinition = "TEXT")
    private String descricaoFisica;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_fk")
    private EnderecoRequest endereco;

    // OneToMany Identificacoes
    @OneToMany(mappedBy = "pessoaRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IdentificacaoRequest> identificacoes = new ArrayList<>();

    // OneToMany Contactos
    @OneToMany(mappedBy = "pessoaRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContactoRequest> contactos = new ArrayList<>();

    /*@ElementCollection
    @CollectionTable(name = "interviniente_identificacoes", joinColumns = @JoinColumn(name = "interviniente_id"))
    private List<IdentificacaoRequest> identificacoes = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "interviniente_contactos", joinColumns = @JoinColumn(name = "interviniente_id"))
    private List<ContactoRequest> contactos = new ArrayList<>();*/

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


    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Long getIdNacionalidade() {
        return idNacionalidade;
    }

    public void setIdNacionalidade(Long idNacionalidade) {
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


    public EnderecoRequest getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoRequest endereco) {
        this.endereco = endereco;
    }

    public List<IdentificacaoRequest> getIdentificacoes() {
        return identificacoes;
    }

    public void setIdentificacoes(List<IdentificacaoRequest> identificacoes) {
        this.identificacoes = identificacoes;
    }

    public List<ContactoRequest> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoRequest> contactos) {
        this.contactos = contactos;
    }

    /* public List<IdentificacaoRequest> getIdentificacoes() {
        return identificacoes;
    }

    public void setIdentificacoes(List<IdentificacaoRequest> identificacoes) {
        this.identificacoes = identificacoes;
    }

    public List<ContactoRequest> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoRequest> contactos) {
        this.contactos = contactos;
    }*/
}
