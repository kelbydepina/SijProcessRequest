package cv.pn.processmanagement.business.processRequest.services;

import cv.pn.processmanagement.business.processRequest.*;
import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//Ela fornece métodos para criar e recuperar instruções de processo.

@Service
public class ProcessService implements IProcessService {

    private final ProcessRepository processRepository;


    public ProcessService(ProcessRepository processRepository) {
        this.processRepository = processRepository;

    }


    @Override
    public APIResponse saveProcessStep(CreateProcessDto dto) {
        try {
                ProcessRequest processIntruction = new ProcessRequest();

                BeanUtils.copyProperties(dto, processIntruction);
                processIntruction.setStatus("Sij process save");
                processRepository.save(processIntruction);

            return new APIResponse.buildAPIResponse()
                    .setStatus(true)
                    .setDetails(Collections.singletonList(processIntruction))
                    .setStatusText(MessageState.SUCESSO)
                    .builder();
        } catch (Exception e) {
            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText(MessageState.ERRO)
                    .setDetails(Collections.singletonList(e.getMessage()))
                    .builder();
        }
    }



    @Override
    public APIResponse getAllProcessIntruction() {

        try {
                List<ProcessRequest> entities = processRepository.findAll();

                List<ProcessResponseDtos> dtos = entities.stream()
                        .map(this::mappingProcessIntruction)
                        .collect(Collectors.toList());

            return new APIResponse.buildAPIResponse()
                    .setStatus(true)
                    .setStatusText(MessageState.SUCESSO)
                    .setDetails(Collections.singletonList(dtos))
                    .builder();

        } catch (Exception e) {
            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText(MessageState.ERRO)
                    .setDetails(Collections.singletonList(e.getMessage()))
                    .builder();
        }
    }

    private ProcessResponseDtos mappingProcessIntruction(ProcessRequest entity) { //Métudo auxiliar Converter uma entidade ProcessIntruction em um DTO ProcessResponseDtos.
        ProcessResponseDtos dto = new ProcessResponseDtos(); //Cria um DTO vazio.
        BeanUtils.copyProperties(entity, dto); //Copia propriedades da entidade para o DTO.
        return dto; //Retorna o DTO.
    }

}
