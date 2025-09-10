package cv.pn.processmanagement.business.atorRequest;




import cv.pn.processmanagement.business.empressaRequest.EmpresaDto;
import cv.pn.processmanagement.business.pessoaRequest.PessoaDto;
import cv.pn.processmanagement.enums.ActorType;
import cv.pn.processmanagement.enums.ActorsCharacteristics;
import cv.pn.processmanagement.enums.FlagNational;
import cv.pn.processmanagement.enums.PersonType;




public class CreateAtorRequestDto {

    private ActorsCharacteristics ator;
    private ActorType tipoAtor;
    private PersonType tipoPessoa;
    private FlagNational flagNacional;
    private Boolean detido = false;
    private String dataDetencao;
    //@JsonDeserialize(using = LocalTimeDeserializer.class)
   // @JsonSerialize(using = LocalTimeSerializer.class)
   // @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
    private String horaDetencao;
    @javax.validation.Valid
    @javax.validation.constraints.NotNull(message = "JASON INVALIDO")
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
