package cv.pn.processmanagement.business.contatoRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cv.pn.processmanagement.business.empressaRequest.EmpresaRequest;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRequest;
import cv.pn.processmanagement.commons.CommonsAttributes;

import javax.persistence.*;


@Entity
@Table(name = "Contacto_Request")
public class ContactoRequest extends CommonsAttributes {

    @Column(name = "contact_type", length = 50)
    private String tipo;

    @Column(name = "contact", length = 100)
    private String contacto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_fk")
    private PessoaRequest pessoaRequest;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_fk")
    private EmpresaRequest empresaRequest;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
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
}
