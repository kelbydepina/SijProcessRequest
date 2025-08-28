package cv.pn.processmanagement.business.processRequest;


import cv.pn.processmanagement.business.atorRequest.AtorDto;
import cv.pn.processmanagement.business.fileRequest.FileRequestDto;
import cv.pn.processmanagement.enums.OrigemQueixa;
import cv.pn.processmanagement.enums.TipoPrazoInvestigacao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public class ProcessDto implements Serializable {

    private String id;

    private String tipoCrime;
    private String observacao;
    private Integer prazoInvestigacao;
    private TipoPrazoInvestigacao tipoPrazoInvestigacao; // "DIA", "MES", "ANO"
    private String comarcaCode;
    private String ComarcaDescription;
    private String numeroProcesso;
    private OrigemQueixa origemQueixa; // "PN", "MP", "OUTRA"
    private String numeroReferencia;
    private String procurador;
    private LocalDate prazoExame;
    private LocalDate prazoReExame;
    private Integer versao;
    private List<AtorDto> atorDtos;
    private List<FileRequestDto> fileRequestDtos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public void setOrigemQueixa(OrigemQueixa origemQueixa) {
        this.origemQueixa = origemQueixa;
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

    public List<AtorDto> getAtorDtos() {
        return atorDtos;
    }

    public void setAtorDtos(List<AtorDto> atorDtos) {
        this.atorDtos = atorDtos;
    }

    public List<FileRequestDto> getFileRequestDtos() {
        return fileRequestDtos;
    }

    public void setFileRequestDtos(List<FileRequestDto> fileRequestDtos) {
        this.fileRequestDtos = fileRequestDtos;
    }
}
