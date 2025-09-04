package cv.pn.processmanagement.business.atorRequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import cv.pn.processmanagement.business.empressaRequest.EmpresaRequest;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRequest;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.commons.CommonsAttributes;
import cv.pn.processmanagement.enums.ActorType;
import cv.pn.processmanagement.enums.ActorsCharacteristics;
import cv.pn.processmanagement.enums.FlagNational;
import cv.pn.processmanagement.enums.PersonType;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "ator_request")
public class AtorRequest extends CommonsAttributes {


    @Enumerated(EnumType.STRING)
    @Column(name = "actorsCharacteristics", length = 30, nullable = false)
    private ActorsCharacteristics ator;

    @Enumerated(EnumType.STRING)
    @Column(name = "actorType", length = 30, nullable = false)
    private ActorType tipoAtor;

    @Enumerated(EnumType.STRING)
    @Column(name = "personType", length = 30, nullable = false)
    private PersonType tipoPessoa;

    @Enumerated(EnumType.STRING)
    @Column(name = "flag_national", length = 30, nullable = false)
    private FlagNational flagNacional;

    @Column(name = "detained")
    private Boolean detido = false;

    @Column(name = "date_of_detention")
    private LocalDate dataDetencao;

    @Column(name = "time_of_detention")
    private LocalTime horaDetencao;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_fk")
    private PessoaRequest pessoaRequest;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_fk")
    private EmpresaRequest empresaRequest;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "process_fk", nullable = false)
    private ProcessRequest processRequest;

    public ActorsCharacteristics getAtor() {
        return ator;
    }

    public void setAtor(ActorsCharacteristics ator) {
        this.ator = ator;
    }


    public ActorType getTipoAtor() {
        return tipoAtor;
    }

    public void setTipoAtor(ActorType tipoAtor) {
        this.tipoAtor = tipoAtor;
    }


    public PersonType getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(PersonType tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public FlagNational getFlagNacional() {
        return flagNacional;
    }

    public void setFlagNacional(FlagNational flagNacional) {
        this.flagNacional = flagNacional;
    }

    public Boolean getDetido() {
        return detido;
    }

    public void setDetido(Boolean detido) {
        this.detido = detido;
    }

    public LocalDate getDataDetencao() {
        return dataDetencao;
    }

    public void setDataDetencao(LocalDate dataDetencao) {
        this.dataDetencao = dataDetencao;
    }

    public LocalTime getHoraDetencao() {
        return horaDetencao;
    }

    public void setHoraDetencao(LocalTime horaDetencao) {
        this.horaDetencao = horaDetencao;
    }

    public PessoaRequest getPessoaRequest() {
        return pessoaRequest;
    }

    public void setPessoaRequest(PessoaRequest pessoaRequest) {
        this.pessoaRequest = pessoaRequest;
    }

    public EmpresaRequest getEmpresaRequest() {
        return empresaRequest;
    }

    public void setEmpresaRequest(EmpresaRequest empresaRequest) {
        this.empresaRequest = empresaRequest;
    }

    public ProcessRequest getProcessRequest() {
        return processRequest;
    }

    public void setProcessRequest(ProcessRequest processRequest) {
        this.processRequest = processRequest;
    }

}
