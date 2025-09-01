package cv.pn.processmanagement.business.processRequest;

import cv.pn.processmanagement.commons.CommonsParametrizationAttributesDto;
import cv.pn.processmanagement.enums.OrigemQueixa;
import cv.pn.processmanagement.enums.TipoPrazoInvestigacao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProcessResponseDtos extends ProcessDto {

    private String id;
    private Boolean active;
    private LocalDateTime dateCreate;

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

    /*private CommonsParametrizationAttributesDto organic;
    private CommonsParametrizationAttributesDto processType;
    private String status;
    private CommonsParametrizationAttributesDto processPhase;
    private String referenceProcess;

    private String colorProcess;
    private String remainingProcessDate;
    private String durationProcessDate;

    private CommonsParametrizationAttributesDto processClassification;

    private String changePhaseNote;
    private CommonsParametrizationAttributesDto command;
    private Boolean effectiveOrganic;*/



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String getTipoCrime() {
        return tipoCrime;
    }

    @Override
    public void setTipoCrime(String tipoCrime) {
        this.tipoCrime = tipoCrime;
    }

    @Override
    public String getObservacao() {
        return observacao;
    }

    @Override
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public Integer getPrazoInvestigacao() {
        return prazoInvestigacao;
    }

    @Override
    public void setPrazoInvestigacao(Integer prazoInvestigacao) {
        this.prazoInvestigacao = prazoInvestigacao;
    }

    @Override
    public TipoPrazoInvestigacao getTipoPrazoInvestigacao() {
        return tipoPrazoInvestigacao;
    }

    @Override
    public void setTipoPrazoInvestigacao(TipoPrazoInvestigacao tipoPrazoInvestigacao) {
        this.tipoPrazoInvestigacao = tipoPrazoInvestigacao;
    }

    @Override
    public String getComarcaCode() {
        return comarcaCode;
    }

    @Override
    public void setComarcaCode(String comarcaCode) {
        this.comarcaCode = comarcaCode;
    }

    @Override
    public String getComarcaDescription() {
        return ComarcaDescription;
    }

    @Override
    public void setComarcaDescription(String comarcaDescription) {
        ComarcaDescription = comarcaDescription;
    }

    @Override
    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    @Override
    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    @Override
    public OrigemQueixa getOrigemQueixa() {
        return origemQueixa;
    }

    @Override
    public void setOrigemQueixa(OrigemQueixa origemQueixa) {
        this.origemQueixa = origemQueixa;
    }

    @Override
    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    @Override
    public void setNumeroReferencia(String numeroReferencia) {
        this.numeroReferencia = numeroReferencia;
    }

    @Override
    public String getProcurador() {
        return procurador;
    }

    @Override
    public void setProcurador(String procurador) {
        this.procurador = procurador;
    }

    @Override
    public String getOrganica() {
        return organica;
    }

    @Override
    public void setOrganica(String organica) {
        this.organica = organica;
    }

    @Override
    public LocalDate getPrazoExame() {
        return prazoExame;
    }

    @Override
    public void setPrazoExame(LocalDate prazoExame) {
        this.prazoExame = prazoExame;
    }

    @Override
    public LocalDate getPrazoReExame() {
        return prazoReExame;
    }

    @Override
    public void setPrazoReExame(LocalDate prazoReExame) {
        this.prazoReExame = prazoReExame;
    }

    @Override
    public Integer getVersao() {
        return versao;
    }

    @Override
    public void setVersao(Integer versao) {
        this.versao = versao;
    }
}
