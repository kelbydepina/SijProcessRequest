/*package cv.pn.processmanagement.business.fileRequest.controller;

import cv.pn.processmanagement.business.fileRequest.CreateFileRequestDto;
import cv.pn.processmanagement.business.fileRequest.FileRequestDto;
import cv.pn.processmanagement.business.fileRequest.service.IFileRequestService;
import cv.pn.processmanagement.utilities.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/file")
public class FileController {

    private final IFileRequestService iFileRequestService;

    public FileController(IFileRequestService iFileRequestService) {
        this.iFileRequestService = iFileRequestService;
    }

    @Operation(summary = "save File")
    @PostMapping("/criar")
    public ResponseEntity<APIResponse> criarFile(@RequestBody CreateFileRequestDto dto, String processRequest) {

        APIResponse response = iFileRequestService.saveAndUpdateFile((List<FileRequestDto>) dto, processRequest);
        return ResponseEntity.ok(response);
    }
}*/
