package cv.pn.processmanagement.business.fileRequest.controller;

import cv.pn.processmanagement.business.fileRequest.CreateFileRequestDto;
import cv.pn.processmanagement.business.fileRequest.service.IFileRequestService;
import cv.pn.processmanagement.utilities.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "1.0.0/file")
public class FileRequestController {

    private final IFileRequestService iFileRequestService;

    public FileRequestController(IFileRequestService iFileRequestService) {
        this.iFileRequestService = iFileRequestService;
    }

    @Operation(summary = "Save and Update File")
    @PostMapping()
    public ResponseEntity<APIResponse> saveAndUpdateFile(@Valid @RequestBody CreateFileRequestDto dto) {
        return ResponseEntity.ok(iFileRequestService.saveAndUpdateFile(dto));
    }

        @Operation(summary = "Get All File")
        @GetMapping(path = "/relationTableId")
        public ResponseEntity<APIResponse> getAllFile( @PathVariable String relationTableId){
            return ResponseEntity.ok(iFileRequestService.getAllFile(relationTableId));

        }

}
