/*package cv.pn.processmanagement.business.enderecoRequest.services;

import cv.pn.processmanagement.business.enderecoRequest.EnderecoDto;
import cv.pn.processmanagement.business.enderecoRequest.EnderecoRepository;
import cv.pn.processmanagement.business.enderecoRequest.EnderecoRequest;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRepository;
import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class EnderecoService implements IEnderecoService{

    private final EnderecoRepository enderecoRepository;

    private final PessoaRepository pessoaRepository;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaRepository pessoaRepository) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public APIResponse processarEndereco(EnderecoDto dto, String pessoaRequest) {

        try {

            EnderecoRequest enderecoRequest = new EnderecoRequest();

            BeanUtils.copyProperties(dto, enderecoRequest);
            enderecoRequest.setUserCreate("SYSTEM");
            enderecoRepository.save(enderecoRequest);

            return new APIResponse.buildAPIResponse()
                    .setStatus(true)
                    .setDetails(Collections.singletonList(enderecoRequest))
                    .setStatusText(MessageState.SUCESSO)
                    .builder();

        } catch (Exception e) {
            //e.printStackTrace(); // MOSTRAR erro real no console
            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText(MessageState.ERRO)
                    .setDetails(Collections.singletonList("Erro ao salvar endereco: " + e.getMessage()))
                    .builder();
        }
    }
}*/
