package cv.pn.processmanagement.business.enderecoRequest;

import cv.pn.processmanagement.business.pessoaRequest.PessoaRequest;
import cv.pn.processmanagement.commons.CommonsAttributes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Endereco_Request")
public class EnderecoRequest extends CommonsAttributes {

    @Column(name = "island", length = 100)
    private String ilha;

    @Column(name = "municipality", length = 100)
    private String concelho;

    @Column(name = "parish", length = 100)
    private String freguesia;

    @Column(name = "area", length = 100)
    private String zona;

    @Column(name = "locality", length = 100)
    private String localidade;

    @Column(name = "island_id")
    private Long idIlha;

    @Column(name = "id_municipality")
    private Long idConcelho;

    @Column(name = "id_parish")
    private Long idFreguesia;

    @Column(name = "id_area")
    private Long idZona;

    @Column(name = "id_locality")
    private Long idLocalidade;

    public String getIlha() {
        return ilha;
    }

    public void setIlha(String ilha) {
        this.ilha = ilha;
    }

    public String getConcelho() {
        return concelho;
    }

    public void setConcelho(String concelho) {
        this.concelho = concelho;
    }

    public String getFreguesia() {
        return freguesia;
    }

    public void setFreguesia(String freguesia) {
        this.freguesia = freguesia;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Long getIdIlha() {
        return idIlha;
    }

    public void setIdIlha(Long idIlha) {
        this.idIlha = idIlha;
    }

    public Long getIdConcelho() {
        return idConcelho;
    }

    public void setIdConcelho(Long idConcelho) {
        this.idConcelho = idConcelho;
    }

    public Long getIdFreguesia() {
        return idFreguesia;
    }

    public void setIdFreguesia(Long idFreguesia) {
        this.idFreguesia = idFreguesia;
    }

    public Long getIdZona() {
        return idZona;
    }

    public void setIdZona(Long idZona) {
        this.idZona = idZona;
    }

    public Long getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Long idLocalidade) {
        this.idLocalidade = idLocalidade;
    }


}
