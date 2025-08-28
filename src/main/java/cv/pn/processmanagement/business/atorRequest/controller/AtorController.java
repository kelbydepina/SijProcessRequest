package cv.pn.processmanagement.business.atorRequest.controller;

import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.business.atorRequest.services.IAtorRequestService;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.utilities.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ator")
public class AtorController {

    public final IAtorRequestService iAtorRequestService;

    public AtorController(IAtorRequestService iAtorRequestService) {
        this.iAtorRequestService = iAtorRequestService;
    }

    @Operation(summary = "save Actor")
    @PostMapping("/criar")
    public ResponseEntity<APIResponse> criarAtor(@RequestBody CreateAtorRequestDto dto, String processRequest) {

        APIResponse response = iAtorRequestService.saveAtorRequest(dto , processRequest);
        return ResponseEntity.ok(response);
    }


    @Operation(summary = "Get All Actor")
    @GetMapping()
    public ResponseEntity<APIResponse> getAllAtor() {
        APIResponse response = iAtorRequestService.getAllAtor();
        return ResponseEntity.ok(response);
    }
}
