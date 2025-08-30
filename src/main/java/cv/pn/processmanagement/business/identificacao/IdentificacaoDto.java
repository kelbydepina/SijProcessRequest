package cv.pn.processmanagement.business.identificacao;

import cv.pn.processmanagement.enums.DocumentType;



import java.time.LocalDate;

public class IdentificacaoDto {

    /*@NotNull(message = "O campo 'tipo' é obrigatório")
    @Pattern(regexp = "BI|TRE|NIF|CNI|PASS|CC",
            message = "O campo 'tipo' deve ser preenchido com uma das opções: CNI, PASS, BI, TRE, NIF, CC")*/
    private DocumentType  tipo;
    private String numero;
    private String paisEmissor;
    private String entidadeEmissora;
    private LocalDate dataEmissao;
    private LocalDate dataValidade;

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
}
