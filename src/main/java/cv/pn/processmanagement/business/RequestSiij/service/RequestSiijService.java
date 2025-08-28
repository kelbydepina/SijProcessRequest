package cv.pn.processmanagement.business.RequestSiij.service;
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
import java.util.Collections;
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


        try {


            if (dto == null || dto.getProcess() == null) {
                return new APIResponse.buildAPIResponse()
                        .setStatus(false)
                        .setStatusText(MessageState.ERRO)
                        .setDetails(List.of("O objeto process é obrigatório."))
                        .builder();
            }

                if (processRepository.existsByNumeroProcesso(dto.getProcess().getNumeroProcesso())) {
                    return new APIResponse.buildAPIResponse()
                            .setStatus(false)
                            .setDetails(Collections.singletonList("Numero de processo: " + dto.getProcess().getNumeroProcesso() + " ja existe"))
                            .setStatusText(MessageState.ERRO)
                            .builder();
                }


                APIResponse response = iProcessService.saveProcessStep(dto.getProcess());
                Object detailObj = response.getDetails().get(0);

                if (!(detailObj instanceof ProcessRequest)) {

                    throw new IllegalStateException("Objeto retornado não é do tipo ProcessRequest");
                }

                ProcessRequest processRequest = (ProcessRequest) detailObj;

                if (dto.getAtores() == null || dto.getAtores().isEmpty()) {

                    return new APIResponse.buildAPIResponse()
                            .setStatus(false)
                            .setStatusText(MessageState.ERRO)
                            .setDetails(Collections.singletonList("Os dados do Autor é Obrigatorio "))
                            .builder();
                }

                if (dto.getFiles() == null || dto.getFiles().isEmpty()) {

                    return new APIResponse.buildAPIResponse()
                            .setStatus(false)
                            .setStatusText(MessageState.ERRO)
                            .setDetails(Collections.singletonList("Os dados do Arquivo é Obrigatorio "))
                            .builder();
                }


                dto.getAtores().forEach(atorDto -> {
                    iAtorRequestService.saveAtorRequest(atorDto, ((ProcessRequest) detailObj).getId());
                    //iAtorRequestService.saveAtorRequest(atorDto);
                });


                iFileRequestService.saveAndUpdateFile(dto.getFiles(), ((ProcessRequest) detailObj).getId());
                // iFileRequestService.saveAndUpdateFile(dto.getFiles(), processRequest.getId());


                return new APIResponse.buildAPIResponse()
                        .setStatus(true)
                        .setStatusText(MessageState.SUCESSO)
                        .setDetails(List.of(processRequest.getIdentificadorProcesso()))
                        .builder();



        } catch (Exception e) {

            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText(MessageState.ERRO_SAVE)
                    .setDetails(Collections.singletonList(e.getMessage()))
                    .builder();

        }

    }

}

