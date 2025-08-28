package cv.pn.processmanagement.business.pessoaRequest.controller;


import cv.pn.processmanagement.business.pessoaRequest.PessoaContainerDto;
import cv.pn.processmanagement.business.pessoaRequest.PessoaDto;
import cv.pn.processmanagement.business.pessoaRequest.services.IPessoaRequestService;
import cv.pn.processmanagement.utilities.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    public final IPessoaRequestService iPessoaRequestService;

    public PessoaController(IPessoaRequestService iPessoaRequestService) {
        this.iPessoaRequestService = iPessoaRequestService;
    }

    @Operation(summary = "save Pessoa")
    @PostMapping("/criar")
    public ResponseEntity<APIResponse> criarPessoa(@RequestBody PessoaContainerDto containerDto) {
        PessoaDto dto = containerDto.getPessoa();
        return ResponseEntity.ok(iPessoaRequestService.createPessoa(dto));
    }
}
