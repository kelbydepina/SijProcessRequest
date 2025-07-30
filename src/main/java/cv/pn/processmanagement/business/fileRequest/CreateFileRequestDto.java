package cv.pn.processmanagement.business.fileRequest;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

public class CreateFileRequestDto implements Serializable {

    @NotBlank(message = "O criador do arquivo é obrigatório")
    private String userCreate;
    private String processId;
    private List<FileRequestDto> files;

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public List<FileRequestDto> getFiles() {
        return files;
    }

    public void setFiles(List<FileRequestDto> files) {
        this.files = files;
    }


}
