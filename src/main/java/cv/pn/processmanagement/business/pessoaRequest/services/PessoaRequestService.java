package cv.pn.processmanagement.business.pessoaRequest.services;


import cv.pn.processmanagement.business.contatoRequest.ContactoDto;
import cv.pn.processmanagement.business.contatoRequest.ContactoRequest;
import cv.pn.processmanagement.business.enderecoRequest.EnderecoRequest;
import cv.pn.processmanagement.business.identificacao.IdentificacaoDto;
import cv.pn.processmanagement.business.identificacao.IdentificacaoRequest;
import cv.pn.processmanagement.business.pessoaRequest.PessoaDto;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRepository;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRequest;
import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
public class PessoaRequestService implements IPessoaRequestService {

    private final PessoaRepository pessoaRepository;

    public PessoaRequestService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;

    }
    @Transactional
    @Override
    public APIResponse createPessoa(PessoaDto dto) {

        try {
            PessoaRequest pessoa = new PessoaRequest();
            BeanUtils.copyProperties(dto, pessoa);
            pessoa.setUserCreate("SYSTEM");

            // Processar endereço
            if (dto.getEndereco() != null) {
                EnderecoRequest endereco = new EnderecoRequest();
                BeanUtils.copyProperties(dto.getEndereco(), endereco);
                endereco.setUserCreate("SYSTEM");
                pessoa.setEndereco(endereco);
            }

            // Processar identificações
            if (dto.getIdentificacoes() != null) {
                for (IdentificacaoDto identificacaoDto : dto.getIdentificacoes()) {
                    IdentificacaoRequest identificacao = new IdentificacaoRequest();
                    BeanUtils.copyProperties(identificacaoDto, identificacao);
                    identificacao.setPessoaRequest(pessoa); // Define o lado proprietário
                    identificacao.setUserCreate("SYSTEM");
                    pessoa.getIdentificacoes().add(identificacao);
                }
            }

            // Processar contactos
            if (dto.getContactos() != null) {
                for (ContactoDto contactoDto : dto.getContactos()) {
                    ContactoRequest contacto = new ContactoRequest();
                    BeanUtils.copyProperties(contactoDto, contacto);
                    contacto.setPessoaRequest(pessoa); // Define o lado proprietário
                    contacto.setUserCreate("SYSTEM");
                    pessoa.getContactos().add(contacto);
                }
            }

            pessoaRepository.save(pessoa);

            // Criar mapa simples com a estrutura {"pessoa": dados}
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("pessoa", pessoa);

            return new APIResponse.buildAPIResponse()
                    .setStatus(true)
                    .setDetails(Collections.singletonList(pessoa))
                    .setStatusText(MessageState.SUCESSO)
                    .builder();
        } catch (Exception e) {
            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText(MessageState.ERRO)
                    .setDetails(Collections.singletonList("Erro ao salvar pessoa: " + e.getMessage()))
                    .builder();
        }

    }

}
