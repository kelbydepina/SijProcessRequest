package cv.pn.processmanagement.business.atorRequest.services;

import cv.pn.processmanagement.business.atorRequest.AtorRequest;
import cv.pn.processmanagement.business.atorRequest.AtorRequestRepository;
import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.business.processRequest.ProcessRepository;
import cv.pn.processmanagement.exceptions.RecordNotFoundException;
import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AtorRequestService implements IAtorRequestService {

    private final AtorRequestRepository atorRequestRepository;

    private final ProcessRepository processRepository;


    public AtorRequestService(AtorRequestRepository atorRequestRepository, ProcessRepository processRepository) {
        this.atorRequestRepository = atorRequestRepository;
        this.processRepository = processRepository;

    }

    @Override
    public APIResponse saveAtorRequest(CreateAtorRequestDto dto, String processRequet) {


        try {

            ProcessRequest process = processRepository.findById(processRequet)
                        .orElseThrow(() -> new RuntimeException("Processo não encontrado"));

            AtorRequest ator = new AtorRequest();

            BeanUtils.copyProperties(dto, ator);
            ator.setProcessRequest(process);
            ator.setUserCreate("SYSTEM");
            atorRequestRepository.save(ator);

            return new APIResponse.buildAPIResponse()
                    .setStatus(true)
                    .setStatusText(MessageState.SUCESSO)
                    .builder();

        } catch (Exception e) {
            e.printStackTrace(); // MOSTRAR erro real no console
            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText(MessageState.ERRO)
                    .setDetails(Collections.singletonList("Erro ao salvar ator: " + e.getMessage()))
                    .builder();
        }
    }

    @Override
    public APIResponse getAllAtor() {
        try {
            List<AtorRequest> atores = atorRequestRepository.findAll();

            return new APIResponse.buildAPIResponse()
                    .setStatus(true)
                    .setStatusText(MessageState.SUCESSO)
                    .setDetails(Collections.singletonList(atores))
                    .builder();

        } catch (Exception e) {
            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText(MessageState.ERRO)
                    .setDetails(Collections.singletonList(e.getMessage()))
                    .builder();
        }
    }


}

