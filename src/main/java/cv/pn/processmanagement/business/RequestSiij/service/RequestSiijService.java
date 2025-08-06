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



              try{

                  if (processRepository.existsByProcessNumber(dto.getProcess().getProcessNumber())){
                      return new APIResponse.buildAPIResponse()
                              .setStatus(false)
                              .setDetails(Collections.singletonList("Numero de processo:" + dto.getProcess().getProcessNumber() + " ja existe no base de dados"))
                              .setStatusText(MessageState.ERRO)
                              .builder();

                  }


                  APIResponse response = iProcessService.saveProcessStep(dto.getProcess());

                    Object detailObj = response.getDetails().get(0);

                    if (!(detailObj instanceof ProcessRequest)) {

                        throw new IllegalStateException("Objeto retornado não é do tipo ProcessRequest");
                    }



                   dto.getAtores().forEach(atorDto -> {
                        iAtorRequestService.saveAtorRequest(atorDto, ((ProcessRequest) detailObj).getId());
                    });

                    iFileRequestService.saveAndUpdateFile(dto.getFiles(), ((ProcessRequest) detailObj).getId() );




            return new APIResponse.buildAPIResponse()
                .setStatus(true)
                .setStatusText(MessageState.SUCESSO)
                .setDetails(List.of(((ProcessRequest) detailObj).getIdentifierProcess())).builder();


    } catch (Exception e) {

            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText("Erro ao salvar processo completo: " + e.getMessage())
                    .setDetails(List.of(e.getMessage()))
                    .builder();
        }
    }




}

