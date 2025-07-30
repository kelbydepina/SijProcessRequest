package cv.pn.processmanagement.business.RequestSiij;

import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.business.fileRequest.CreateFileRequestDto;
import cv.pn.processmanagement.business.processRequest.CreateProcessDto;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class RequestSiijDto implements Serializable {

    @Valid
    @NotNull(message = "Processo é obrigatório")
    private CreateProcessDto process;
    @Valid
    @NotEmpty(message = "Lista de atores é obrigatória")
    private List<CreateAtorRequestDto> atores;
    @Valid
    @NotNull(message = "Arquivo é obrigatório")
    private CreateFileRequestDto files;

    public CreateProcessDto getProcess() {
        return process;
    }

    public void setProcess(CreateProcessDto process) {
        this.process = process;
    }

    public List<CreateAtorRequestDto> getAtores() {
        return atores;
    }

    public void setAtores(List<CreateAtorRequestDto> atores) {
        this.atores = atores;
    }

    public CreateFileRequestDto getFiles() {
        return files;
    }

    public void setFiles(CreateFileRequestDto files) {
        this.files = files;
    }
}
