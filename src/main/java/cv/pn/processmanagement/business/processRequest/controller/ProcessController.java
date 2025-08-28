package cv.pn.processmanagement.business.processRequest.controller;

import cv.pn.processmanagement.business.processRequest.CreateProcessDto;
import cv.pn.processmanagement.business.processRequest.services.IProcessService;
import cv.pn.processmanagement.utilities.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "1.0.0/process")
public class ProcessController {

    private final IProcessService iProcessService;

    public ProcessController(IProcessService iProcessService) {
        this.iProcessService = iProcessService;
    }

    @Operation(summary = "Save Process")
    @PostMapping()
    public ResponseEntity<APIResponse> saveProcess(@RequestBody CreateProcessDto dto) {


        return ResponseEntity.ok(iProcessService.saveProcessStep(dto));
    }

    // Buscar todos os processos
    @Operation(summary = "Get All Process")
    @GetMapping()
    public ResponseEntity<APIResponse> getAllProcess() {
        return ResponseEntity.ok(iProcessService.getAllprocessIntruction());
    }
}
