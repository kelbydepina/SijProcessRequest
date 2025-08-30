package cv.pn.processmanagement.business.atorRequest;


import cv.pn.processmanagement.business.empressaRequest.EmpresaDto;
import cv.pn.processmanagement.business.pessoaRequest.PessoaDto;
import cv.pn.processmanagement.enums.ActorType;
import cv.pn.processmanagement.enums.ActorsCharacteristics;
import cv.pn.processmanagement.enums.PersonType;

import java.time.LocalDateTime;

public class CreateAtorRequestDto {

    private ActorsCharacteristics ator;
    private ActorType tipoAtor;
    private PersonType tipoPessoa;
    private Boolean detido;
    private LocalDateTime dataHoraDetencao;
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

    public LocalDateTime getDataHoraDetencao() {
        return dataHoraDetencao;
    }

    public void setDataHoraDetencao(LocalDateTime dataHoraDetencao) {
        this.dataHoraDetencao = dataHoraDetencao;
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


    public boolean isDetido() {
        return false;
    }
}
