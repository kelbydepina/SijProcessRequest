package cv.pn.processmanagement.business.RequestSiij.controller;

import cv.pn.processmanagement.business.RequestSiij.RequestSiijDto;
import cv.pn.processmanagement.business.RequestSiij.service.IRequestSiijService;
import cv.pn.processmanagement.utilities.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/requestProcessSij")

public class RequestProcessSijController {

    private final IRequestSiijService iRequestSiijService;

    public RequestProcessSijController(IRequestSiijService iRequestSiijService) {
        this.iRequestSiijService = iRequestSiijService;
    }

    @Operation(summary = "save Full Process")
    @PostMapping()
    public ResponseEntity<APIResponse> criarRequestSiij(@javax.validation.Valid @RequestBody RequestSiijDto dto) {
        APIResponse response = iRequestSiijService.saveFullProcess(dto);
        return ResponseEntity.ok(response);
    }

}
