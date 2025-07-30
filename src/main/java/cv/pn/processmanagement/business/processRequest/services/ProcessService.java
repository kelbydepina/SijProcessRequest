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
    public APIResponse saveProcessStep(CreateProcessDto dto) { //Salvar um novo processo (ProcessIntruction) a partir dos dados fornecidos por CreateProcessDto.
        try {
            ProcessRequest processIntruction = new ProcessRequest(); //Cria uma nova instância de ProcessIntruction

            BeanUtils.copyProperties(dto, processIntruction); //Copia propriedades do DTO para a entidade usando BeanUtils.copyProperties
            processRepository.save(processIntruction); //Salva a entidade no repositório

            return new APIResponse.buildAPIResponse() //Retorna uma resposta de sucesso encapsulada em APIResponse
                    .setStatus(true)
                    .setDetails(Collections.singletonList(processIntruction))
                    .setStatusText(MessageState.SUCESSO)
                    .builder();
        } catch (Exception e) {
            return new APIResponse.buildAPIResponse()  //Retorna uma resposta de erro encapsulada em APIResponse
                    .setStatus(false)
                    .setStatusText(MessageState.ERRO)
                    .setDetails(Collections.singletonList(e.getMessage()))
                    .builder();
        }
    }



    @Override
    public APIResponse getAllProcessIntruction() { //Recuperar todos os registros de ProcessIntruction do banco de dados e convertê-los em DTOs.

        try {
            List<ProcessRequest> entities = processRepository.findAll(); //Busca todas as entidades/lista no repositório

            List<ProcessResponseDtos> dtos = entities.stream()//Converte cada entidade para DTO usando o métudo auxiliar mappingProcessIntruction
                    .map(this::mappingProcessIntruction)
                    .collect(Collectors.toList());

            return new APIResponse.buildAPIResponse() //Retorna a lista de DTOs encapsulada em APIResponse
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
