package cv.pn.processmanagement.business.fileRequest;



import com.fasterxml.jackson.annotation.JsonIgnore;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.commons.CommonsAttributes;

import javax.persistence.*;

@Entity
@Table(name = "FILE_REQUEST")
public class FileRequest extends CommonsAttributes {

    @Column(name = "content", length = 50000)
    private byte[] content;

    @Column(name = "numero")
    private String numero;

    @Column(name = "mineType")
    private String mineType;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "process_fk", nullable = false)
    private ProcessRequest processRequest;

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProcessRequest getProcessRequest() {
        return processRequest;
    }

    public void setProcessRequest(ProcessRequest processRequest) {
        this.processRequest = processRequest;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMineType(String mineType) {
        return this.mineType;
    }

    public void setMineType(String mineType) {
        this.mineType = mineType;
    }
}

