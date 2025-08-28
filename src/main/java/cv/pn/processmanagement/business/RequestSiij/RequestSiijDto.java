package cv.pn.processmanagement.business.RequestSiij;

import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.business.fileRequest.FileRequestDto;
import cv.pn.processmanagement.business.processRequest.CreateProcessDto;


import java.io.Serializable;
import java.util.List;

public class RequestSiijDto implements Serializable {


        private CreateProcessDto process;

        private List<CreateAtorRequestDto> atores;

        private List<FileRequestDto> files;

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

    public List<FileRequestDto> getFiles() {
        return files;
    }

    public void setFiles(List<FileRequestDto> files) {
        this.files = files;
    }

}
