package cv.pn.processmanagement.business.identificacao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRequest;
import cv.pn.processmanagement.commons.CommonsAttributes;
import cv.pn.processmanagement.enums.DocumentType;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Identificacao_Request")
public class IdentificacaoRequest extends CommonsAttributes {

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type", length = 100)
    private DocumentType tipo;


    @Column(name = "identification_number", length = 100)
    private String numero;

    @Column(name = "issuing_country", length = 100)
    private String paisEmissor;

    @Column(name = "issuing_entity", length = 100)
    private String entidadeEmissora;

    @Column(name = "date_of_issue")
    private LocalDate dataEmissao;

    @Column(name = "expiration_date")
    private LocalDate dataValidade;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pessoa_fk", nullable = false)
    private PessoaRequest pessoaRequest;

    public DocumentType getTipo() {
        return tipo;
    }

    public void setTipo(DocumentType tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPaisEmissor() {
        return paisEmissor;
    }

    public void setPaisEmissor(String paisEmissor) {
        this.paisEmissor = paisEmissor;
    }

    public String getEntidadeEmissora() {
        return entidadeEmissora;
    }

    public void setEntidadeEmissora(String entidadeEmissora) {
        this.entidadeEmissora = entidadeEmissora;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public PessoaRequest getPessoaRequest() {
        return pessoaRequest;
    }

    public void setPessoaRequest(PessoaRequest pessoaRequest) {
        this.pessoaRequest = pessoaRequest;
    }
}
