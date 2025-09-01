package cv.pn.processmanagement.business.pessoaRequest.services;



import cv.pn.processmanagement.business.contatoRequest.ContactoDto;
import cv.pn.processmanagement.business.contatoRequest.ContactoRequest;
import cv.pn.processmanagement.business.enderecoRequest.EnderecoRequest;
import cv.pn.processmanagement.business.identificacao.IdentificacaoDto;
import cv.pn.processmanagement.business.identificacao.IdentificacaoRequest;
import cv.pn.processmanagement.business.identificacao.services.IIdentificacaoService;
import cv.pn.processmanagement.business.pessoaRequest.PessoaDto;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRepository;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRequest;
import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;



@Service
public class PessoaRequestService implements IPessoaRequestService {

    private final PessoaRepository pessoaRepository;

    private final IIdentificacaoService identificacaoService;

    public PessoaRequestService(PessoaRepository pessoaRepository, IIdentificacaoService identificacaoService) {
        this.pessoaRepository = pessoaRepository;


        this.identificacaoService = identificacaoService;
    }
    @Transactional
    @Override
    public APIResponse createPessoa(PessoaDto dto) {

        try {
                PessoaRequest pessoa = new PessoaRequest();
                BeanUtils.copyProperties(dto, pessoa);
                pessoa.setUserCreate("SYSTEM");


                if (dto.getEndereco() != null) {
                    EnderecoRequest endereco = new EnderecoRequest();
                    BeanUtils.copyProperties(dto.getEndereco(), endereco);
                    endereco.setUserCreate("SYSTEM");
                    pessoa.setEndereco(endereco);
            }


                if (dto.getIdentificacoes() != null) {
                    for (IdentificacaoDto identificacaoDto : dto.getIdentificacoes()) {
                        IdentificacaoRequest identificacao = new IdentificacaoRequest();
                        BeanUtils.copyProperties(identificacaoDto, identificacao);
                        identificacao.setPessoaRequest(pessoa);
                        identificacao.setUserCreate("SYSTEM");
                        pessoa.getIdentificacoes().add(identificacao);
                    }
            }


                if (dto.getContactos() != null) {
                    for (ContactoDto contactoDto : dto.getContactos()) {
                        ContactoRequest contacto = new ContactoRequest();
                        BeanUtils.copyProperties(contactoDto, contacto);
                        contacto.setPessoaRequest(pessoa);
                        contacto.setUserCreate("SYSTEM");
                        pessoa.getContactos().add(contacto);
                    }
            }

            pessoaRepository.save(pessoa);

            // Processar identificações se existirem
            if (dto.getIdentificacoes() != null) {
                identificacaoService.processarIdentificacoes(dto.getIdentificacoes(), pessoa);
            }


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
