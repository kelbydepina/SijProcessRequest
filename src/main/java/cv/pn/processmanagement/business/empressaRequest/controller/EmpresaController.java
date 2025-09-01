/*package cv.pn.processmanagement.business.empressaRequest.controller;

import cv.pn.processmanagement.business.empressaRequest.EmpresaDto;
import cv.pn.processmanagement.business.empressaRequest.services.IEmpresaService;
import cv.pn.processmanagement.utilities.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    private final IEmpresaService iEmpresaService;

    public EmpresaController(IEmpresaService iEmpresaService) {
        this.iEmpresaService = iEmpresaService;
    }

    @Operation(summary = "save Empresa")
    @PostMapping("/criar")
    public ResponseEntity<APIResponse> criarEmpresa(@RequestBody EmpresaDto dto) {
        return ResponseEntity.ok(iEmpresaService.createEmpresa(dto));
    }
}*/
