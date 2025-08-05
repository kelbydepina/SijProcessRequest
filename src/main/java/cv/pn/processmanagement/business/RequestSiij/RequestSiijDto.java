package cv.pn.processmanagement.business.RequestSiij;

import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.business.fileRequest.CreateFileRequestDto;
import cv.pn.processmanagement.business.processRequest.CreateProcessDto;

import java.io.Serializable;
import java.util.List;

public class RequestSiijDto implements Serializable {


        private CreateProcessDto process;

        private List<CreateAtorRequestDto> atores;

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
