package cv.pn.processmanagement.business.RequestSiij.service;

import cv.pn.processmanagement.business.RequestSiij.ProcessNumberGenerator;
import cv.pn.processmanagement.business.RequestSiij.RequestSiijDto;

import cv.pn.processmanagement.business.atorRequest.services.IAtorRequestService;

import cv.pn.processmanagement.business.fileRequest.service.IFileRequestService;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.business.processRequest.ProcessRepository;
import cv.pn.processmanagement.business.processRequest.services.IProcessService;
import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public APIResponse saveFullProcess(RequestSiijDto dto) {

        String processNumber = null;

              try{


                    List<ProcessRequest> lastProcesses = processRepository.findTopByOrderByIdentifierProcessDesc();
                    String lastNumber = lastProcesses.isEmpty() ? null : lastProcesses.get(0).getIdentifierProcess();


                     processNumber = ProcessNumberGenerator.generateProcessNumber(lastNumber, "PN");
                     dto.getProcess().setIdentifierProcess(processNumber);


                    APIResponse response = iProcessService.saveProcessStep(dto.getProcess());

                    Object detailObj = response.getDetails().get(0);

                    if (!(detailObj instanceof ProcessRequest)) {

                        throw new IllegalStateException("Objeto retornado não é do tipo ProcessRequest");
                    }

                    ProcessRequest savedProcess = (ProcessRequest) detailObj;
                    String processId = savedProcess.getId();


                   dto.getAtores().forEach(atorDto -> {
                        atorDto.setProcessId(savedProcess.getId());
                        iAtorRequestService.saveAtorRequestStep(atorDto);
                    });


                    dto.getFiles().setProcessId(processId);
                    iFileRequestService.saveAndUpdateFile(dto.getFiles());




            return new APIResponse.buildAPIResponse()
                .setStatus(true)
                .setStatusText(MessageState.SUCESSO)
                .setDetails(List.of(processNumber)).builder();


    } catch (Exception e) {

            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText("Erro ao salvar processo completo: " + e.getMessage())
                    .setDetails(List.of(e.getMessage()))
                    .builder();
        }
    }




}

