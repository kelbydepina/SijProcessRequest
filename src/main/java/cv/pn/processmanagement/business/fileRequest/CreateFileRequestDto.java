package cv.pn.processmanagement.business.fileRequest;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

public class CreateFileRequestDto implements Serializable {

    private List<FileRequestDto> files;

    public List<FileRequestDto> getFiles() {
        return files;
    }

    public void setFiles(List<FileRequestDto> files) {
        this.files = files;
    }


}
