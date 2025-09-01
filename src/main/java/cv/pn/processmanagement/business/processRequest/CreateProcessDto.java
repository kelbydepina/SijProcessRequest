package cv.pn.processmanagement.business.processRequest;


import cv.pn.processmanagement.enums.OrigemQueixa;
import cv.pn.processmanagement.enums.TipoPrazoInvestigacao;

import java.time.LocalDate;


public class CreateProcessDto { //é um DTO de entrada, ou seja, ele encapsula todos os dados que o cliente envia para o backend ao criar um novo registro de processo jurídico. Ele permite separar a lógica da entidade ProcessIntruction, protegendo-a contra alterações diretas e mantendo o sistema desacoplado.

    private String tipoCrime;
    private String observacao;
    private Integer prazoInvestigacao = 1;
    private TipoPrazoInvestigacao tipoPrazoInvestigacao; // "DIA", "MES", "ANO"
    private String comarcaCode;
    private String ComarcaDescription;
    private String numeroProcesso;
    private OrigemQueixa origemQueixa; // "PN", "MP", "OUTRA"
    private String numeroReferencia;
    private String procurador;
    private String organica;
    private LocalDate prazoExame;
    private LocalDate prazoReExame;
    private Integer versao = 1;

    public String getTipoCrime() {
        return tipoCrime;
    }

    public void setTipoCrime(String tipoCrime) {
        this.tipoCrime = tipoCrime;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getPrazoInvestigacao() {
        return prazoInvestigacao;
    }

    public void setPrazoInvestigacao(Integer prazoInvestigacao) {
        this.prazoInvestigacao = prazoInvestigacao;
    }

    public TipoPrazoInvestigacao getTipoPrazoInvestigacao() {
        return tipoPrazoInvestigacao;
    }

    public void setTipoPrazoInvestigacao(TipoPrazoInvestigacao tipoPrazoInvestigacao) {
        this.tipoPrazoInvestigacao = tipoPrazoInvestigacao;
    }

    public String getComarcaCode() {
        return comarcaCode;
    }

    public void setComarcaCode(String comarcaCode) {
        this.comarcaCode = comarcaCode;
    }

    public String getComarcaDescription() {
        return ComarcaDescription;
    }

    public void setComarcaDescription(String comarcaDescription) {
        ComarcaDescription = comarcaDescription;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public OrigemQueixa getOrigemQueixa() {
        return origemQueixa;
    }

    public void setOrigemQueixa(OrigemQueixa origemQueixa) {
        this.origemQueixa = origemQueixa;
    }

    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    public String getProcurador() {
        return procurador;
    }

    public void setProcurador(String procurador) {
        this.procurador = procurador;
    }

    public String getOrganica() {
        return organica;
    }

    public void setOrganica(String organica) {
        this.organica = organica;
    }

    public LocalDate getPrazoExame() {
        return prazoExame;
    }

    public void setPrazoExame(LocalDate prazoExame) {
        this.prazoExame = prazoExame;
    }

    public LocalDate getPrazoReExame() {
        return prazoReExame;
    }

    public void setPrazoReExame(LocalDate prazoReExame) {
        this.prazoReExame = prazoReExame;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }


}
