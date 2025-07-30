package cv.pn.processmanagement.business.fileRequest;


import com.fasterxml.jackson.annotation.JsonIgnore;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.commons.CommonsAttributes;

import javax.persistence.*;

@Entity
@Table(name = "SIGO_FILE")
public class FileRequest extends CommonsAttributes {

    @Column(name = "content", length = 50000)
    private byte[] content;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "type", nullable = false, length = 20)
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
}
