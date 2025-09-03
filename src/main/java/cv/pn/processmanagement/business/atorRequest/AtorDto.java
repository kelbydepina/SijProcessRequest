package cv.pn.processmanagement.business.atorRequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import cv.pn.processmanagement.business.empressaRequest.EmpresaDto;
import cv.pn.processmanagement.business.pessoaRequest.PessoaDto;
import cv.pn.processmanagement.commons.CommonsParametrizationAttributesDto;
import cv.pn.processmanagement.enums.ActorType;
import cv.pn.processmanagement.enums.ActorsCharacteristics;
import cv.pn.processmanagement.enums.PersonType;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AtorDto implements Serializable {

    private ActorsCharacteristics ator;
    private ActorType tipoAtor;
    private PersonType tipoPessoa;
    private Boolean detido;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String dataDetencao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm[:ss]")
    private String horaDetencao;

    private PessoaDto pessoa;
    private EmpresaDto empresa;



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

    public Boolean getDetido() {
        return detido;
    }

    public void setDetido(Boolean detido) {
        this.detido = detido;
    }

    public String getDataDetencao() {
        return dataDetencao;
    }

    public void setDataDetencao(String dataDetencao) {
        this.dataDetencao = dataDetencao;
    }

    public String getHoraDetencao() {
        return horaDetencao;
    }

    public void setHoraDetencao(String horaDetencao) {
        this.horaDetencao = horaDetencao;
    }

    public PessoaDto getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaDto pessoa) {
        this.pessoa = pessoa;
    }

    public EmpresaDto getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDto empresa) {
        this.empresa = empresa;
    }
}
