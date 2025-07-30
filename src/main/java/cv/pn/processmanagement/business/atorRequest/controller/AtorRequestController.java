package cv.pn.processmanagement.business.atorRequest.controller;


import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.business.atorRequest.services.IAtorRequestService;
import cv.pn.processmanagement.utilities.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("1.0.0/ator")
public class AtorRequestController {

    private final IAtorRequestService iAtorRequestService;

    public AtorRequestController(IAtorRequestService iAtorRequestService) {
        this.iAtorRequestService = iAtorRequestService;
    }

    @Operation(summary = "save Actor")
    @PostMapping("/criar")
    public ResponseEntity<APIResponse> criarAtor(@RequestBody CreateAtorRequestDto dto) {
        APIResponse response = iAtorRequestService.saveAtorRequestStep(dto);
        return ResponseEntity.status(response.isStatus()? 200 : 400).body(response);
    }

    @Operation(summary = "Get All Actor")
    @GetMapping()
    public ResponseEntity<APIResponse> getAllAtor() {
        APIResponse response = iAtorRequestService.getAllAtor();
        return ResponseEntity.ok(response);
    }
}
