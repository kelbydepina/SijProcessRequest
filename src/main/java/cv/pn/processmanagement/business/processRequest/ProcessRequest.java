package cv.pn.processmanagement.business.processRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cv.pn.processmanagement.business.atorRequest.AtorRequest;
import cv.pn.processmanagement.business.fileRequest.FileRequest;
import cv.pn.processmanagement.commons.CommonsAttributes;
import cv.pn.processmanagement.enums.OrigemQueixa;
import cv.pn.processmanagement.enums.TipoPrazoInvestigacao;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "PROCESS_REQUEST")
public class  ProcessRequest extends CommonsAttributes {


    @Enumerated(EnumType.STRING)
    @Column(name = "type_deadline_investigation", length = 12)
    private TipoPrazoInvestigacao tipoPrazoInvestigacao;

    @Column(name = "type_crime", length = 150, nullable = false)
    @NotBlank(message = "Tipo de crime é obrigatório")
    private String tipoCrime;

    @Column(name = "observation", length = 512)
    private String observacao;


    @Column(name = "district", length = 100)
    private String comarca;

    @Column(name = "examination_deadline")
    private LocalDate prazoExame;

    @Column(name = "examination_reDeadline")
    private LocalDate prazoReExame;

    //@JsonIgnore
    @Column(name = "process_number", unique = true)
    @NotBlank(message = "Número de processo é obrigatório")
    private String numeroProcesso;

    @Enumerated(EnumType.STRING)
    @Column(name = "origin_complaint", length = 10)
    private OrigemQueixa origemQueixa = OrigemQueixa.PN;

    @Column(name = "reference_number", length = 100)
    private String numeroReferencia;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "prosecutor", length = 200)
    private String procurador;

    // Prazo do exame pericial
    @Column(name = "organic", length = 20, nullable = false)//, nullable = false)
    private String organica; //Unidade orgânica

    @Column(name = "investigation_deadline")
    private Integer prazoInvestigacao = 1;

    @Column(name = "process_identifier",length = 50, unique = true)// updatable = false) //nullable = false)
    private String identificadorProcesso; //Identificador técnico do processo

    @JsonIgnore
    @OneToMany(mappedBy = "processRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AtorRequest> actors = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "processRequest", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileRequest> files;


    @Column(name = "version")
    @Min(value = 1, message = "Versão deve ser no mínimo 1")
    private Integer versao = 1;

    @PrePersist
    public void prePersist() {
        // Se vier null ou 0 do DTO/JSON, forçamos 1
        if (versao == null || versao == 0) {
            versao = 1;
        }
    }

    public List<FileRequest> getFiles() {
        return files;
    }

    public void setFiles(List<FileRequest> files) {
        this.files = files;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public List<AtorRequest> getActors() {
        return actors;
    }

    public void setActors(List<AtorRequest> actors) {
        this.actors = actors;
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

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
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

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    public String getIdentificadorProcesso() {
        return identificadorProcesso;
    }

    public void setIdentificadorProcesso(String identificadorProcesso) {
        this.identificadorProcesso = identificadorProcesso;
    }


}
