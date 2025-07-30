package cv.pn.processmanagement.business.fileRequest.service;

import cv.pn.processmanagement.business.fileRequest.CreateFileRequestDto;
import cv.pn.processmanagement.business.fileRequest.FileRequest;
import cv.pn.processmanagement.business.fileRequest.FileRequestDto;
import cv.pn.processmanagement.utilities.APIResponse;


import java.util.List;

public interface IFileRequestService {

    APIResponse saveAndUpdateFile(CreateFileRequestDto dto);

    List<FileRequestDto> mappingResponseFile(List<FileRequest> files);

    APIResponse getAllFile(String processId);

}
