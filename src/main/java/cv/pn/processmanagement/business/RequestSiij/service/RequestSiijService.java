package cv.pn.processmanagement.business.RequestSiij.service;

import cv.pn.processmanagement.business.RequestSiij.ProcessNumberGenerator;
import cv.pn.processmanagement.business.RequestSiij.RequestSiijDto;


import cv.pn.processmanagement.business.atorRequest.services.IAtorRequestService;

import cv.pn.processmanagement.business.fileRequest.service.IFileRequestService;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.business.processRequest.ProcessRepository;
import cv.pn.processmanagement.business.processRequest.services.IProcessService;
import cv.pn.processmanagement.utilities.APIResponse;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class RequestSiijService implements IRequestSiijService {

    private final IAtorRequestService iAtorRequestService;
    private final IProcessService iProcessService;
    private final IFileRequestService iFileRequestService;
    private final ProcessRepository processRepository;

    public RequestSiijService(IAtorRequestService iAtorRequestService, IProcessService iProcessService, IFileRequestService iFileRequestService, ProcessRepository processRepository) {

        this.iAtorRequestService = iAtorRequestService;
        this.iProcessService = iProcessService;
        this.iFileRequestService = iFileRequestService;
        this.processRepository = processRepository;
    }


    @Override
    public APIResponse saveFullProcess(RequestSiijDto dto) {

        String processNumber = null;

        try{

            // Validação de entrada
            /*if (dto.getProcess() == null || dto.getAtores() == null || dto.getFiles() == null) {
                return new APIResponse.buildAPIResponse()
                        .setStatus(false)
                        .setStatusText("Dados incompletos na requisição")
                        .setDetails(List.of("process, atores e files são obrigatórios"))
                        .builder();*/


            // Recuperar último número de processo
            List<ProcessRequest> lastProcesses = processRepository.findTopByOrderByIdentifierProcessDesc();
            String lastNumber = lastProcesses.isEmpty() ? null : lastProcesses.get(0).getIdentifierProcess();

            //  Geração do número do processo usando ProcessNumberGenerator, prefixado com "PN".
             processNumber = ProcessNumberGenerator.generateProcessNumber(lastNumber, "PN");

            // Setar no DTO
            dto.getProcess().setIdentifierProcess(processNumber);

            // Salvar processo
            APIResponse response = iProcessService.saveProcessStep(dto.getProcess());

            Object detailObj = response.getDetails().get(0);

            if (!(detailObj instanceof ProcessRequest)) {

                throw new IllegalStateException("Objeto retornado não é do tipo ProcessIntruction");
            }

            ProcessRequest detail = (ProcessRequest) detailObj;

                //ProcessIntruction detail = (ProcessIntruction) response.getDetails().get(0);
                String idProcessIntruction = detail.getId(); //

                System.out.println("ID do processo salvo: " + idProcessIntruction);


                dto.getAtores().forEach(atorDto -> {
                    atorDto.setProcessId(idProcessIntruction);
                    iAtorRequestService.saveAtorRequestStep(atorDto);
                });

                dto.getFiles().setProcessId(idProcessIntruction);
                iFileRequestService.saveAndUpdateFile(dto.getFiles());




            String mensagem = "Processo gerado com sucesso: " + processNumber;

            return new APIResponse.buildAPIResponse()
                .setStatus(true)
                .setStatusText(mensagem)
                .setDetails(List.of("sucesso")) // Aqui vai o número gerado no formato 001/ddMMyyyy/PN
                .setProcessNumber(processNumber)
                .builder();

    } catch (Exception e) {

            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText("Erro ao salvar processo completo: " + e.getMessage())
                    .setDetails(List.of(e.getMessage()))
                    .setProcessNumber(processNumber)
                    .builder();
        }
    }




}

