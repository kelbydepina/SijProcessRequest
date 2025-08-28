package cv.pn.processmanagement.business.fileRequest.service;

import cv.pn.processmanagement.business.fileRequest.*;
import cv.pn.processmanagement.business.processRequest.ProcessRepository;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.exceptions.RecordNotFoundException;
import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileRequestService implements IFileRequestService {

    private final FileRequestRepository fileRequestRepository;

    private final ProcessRepository processRepository;


    public FileRequestService(FileRequestRepository fileRequestRepository, ProcessRepository processRepository) {
        this.fileRequestRepository = fileRequestRepository;

        this.processRepository = processRepository;
    }


    @Override
    public APIResponse saveAndUpdateFile(List<FileRequestDto> dto, String processRequest) {
        try {


            // Obter o processo associado
            ProcessRequest processIntruction = processRepository.findById(processRequest)
                    .orElseThrow(() -> new RecordNotFoundException("Processo não encontrado com o ID: " + processRequest));


            List<FileRequestDto> files = dto
                    .stream()
                    .map(fileDto -> {

                        FileRequest file = new FileRequest();

                        file.setType(fileDto.getTipo());
                        file.setName(fileDto.getDescricao());
                        file.setNumero(fileDto.getNumero());
                        file.getMineType(fileDto.getMineType());
                        file.setProcessRequest(processIntruction);
                        file.setUserCreate("SYSTEM");
                       //byte [] content = fileDto.getBase64().getBytes();
                       //file.setContent(content);
                        fileRequestRepository.saveAndFlush(file);

                        return fileDto;

                    }).collect(Collectors.toList());

            CreateFileRequestDto createFileDto = new CreateFileRequestDto();


                  createFileDto.setFiles(dto);


            return new APIResponse.buildAPIResponse().setStatus(true)
                    .setStatusText(MessageState.SUCESSO)
                    .setDetails(Collections.singletonList(createFileDto))
                    .builder();
        } catch (Exception e) {
            return new APIResponse.buildAPIResponse().setStatus(false).setStatusText(MessageState.ERRO).setDetails(Collections.singletonList(e.getMessage())).builder();
        }
    }



    /*@Override
    public APIResponse getAllFile(String relationTable) {

       List<FileRequest> filesActor = fileRequestRepository.findAllByProcessRequestId(relationTable);


        List<Object> objects = new ArrayList<>();

        try {

            List<FileRequestDto> fileDtos = new ArrayList<>();

            fileDtos.addAll(fileDtos);

            objects.add(fileDtos);

            return new APIResponse.buildAPIResponse().setStatus(true)
                    .setStatusText(MessageState.SUCESSO)
                    .setDetails(objects)
                    .builder();
        } catch (Exception e) {
            return new APIResponse.buildAPIResponse().setStatus(false)
                    .setStatusText(MessageState.ERRO)
                    .setDetails(Collections.singletonList(e.getMessage()))
                    .builder();
        }
    }




    public static FileRequestDto mappingResponseFileStatic(FileRequest file) {

        FileRequestDto dto = new FileRequestDto();

        BeanUtils.copyProperties(file, dto);

        String content = new String(file.getContent());

        dto.setBase64(content);

        return dto;

    }*/
}
