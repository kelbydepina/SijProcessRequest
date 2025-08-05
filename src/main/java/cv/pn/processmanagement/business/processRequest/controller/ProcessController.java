/*package cv.pn.processmanagement.business.processRequest.controller;

import cv.pn.processmanagement.business.processRequest.CreateProcessDto;
import cv.pn.processmanagement.business.processRequest.services.IProcessService;
import cv.pn.processmanagement.utilities.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "1.0.0/process")
public class ProcessController {

    private final IProcessService iProcessService;

    public ProcessController(IProcessService iProcessService) {
        this.iProcessService = iProcessService;
    }


    @Operation(summary = "Save Process")
    @PostMapping()
    public ResponseEntity<APIResponse> saveProcess(@Valid @RequestBody CreateProcessDto dto) {
        System.out.println("🚀 Entrou no controller com dados: " + dto);
        return ResponseEntity.ok(iProcessService.saveProcessStep(dto));
    }
    // Buscar todos os processos
    @Operation(summary = "Get All Process")
    @GetMapping
    public ResponseEntity<APIResponse> getAllProcess() {
        return ResponseEntity.ok(iProcessService.getAllProcessIntruction());
    }

    // Buscar processo por ID
    *//*@GetMapping("/{id}")
    public ResponseEntity<ProcessResponseDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(processService.findById(id));
    }*//*

    // Atualizar processo
   *//* @PutMapping("/{id}")
    public ResponseEntity<ProcessResponseDto> update(@PathVariable String id, @RequestBody CreateProcessDto dto) {
        return ResponseEntity.ok(processService.update(id, dto));
    }*//*

    // Deletar processo
    *//*@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        processService.delete(id);
        return ResponseEntity.noContent().build();
    }*//*
}*/

