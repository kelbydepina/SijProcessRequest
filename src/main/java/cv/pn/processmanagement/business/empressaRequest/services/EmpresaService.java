package cv.pn.processmanagement.business.empressaRequest.services;

import cv.pn.processmanagement.business.contatoRequest.ContactoDto;
import cv.pn.processmanagement.business.contatoRequest.ContactoRequest;
import cv.pn.processmanagement.business.empressaRequest.EmpresaDto;
import cv.pn.processmanagement.business.empressaRequest.EmpresaRepository;
import cv.pn.processmanagement.business.empressaRequest.EmpresaRequest;
import cv.pn.processmanagement.business.enderecoRequest.EnderecoRequest;
import cv.pn.processmanagement.utilities.APIResponse;

import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;

@Service
public class EmpresaService implements IEmpresaService{

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

   @Transactional
    @Override
    public APIResponse createEmpresa(EmpresaDto empresaDto) {

        try {

            EmpresaRequest empresa = new EmpresaRequest();

            BeanUtils.copyProperties(empresaDto, empresa, "endereco", "contactos");
            empresa.setUserCreate("SYSTEM");

            if (empresaDto.getEndereco() != null) {
                //System.out.println("Processando endereço da empresa");
                EnderecoRequest endereco = new EnderecoRequest();
                BeanUtils.copyProperties(empresaDto.getEndereco(), endereco);
                endereco.setUserCreate("SYSTEM");
                empresa.setEndereco(endereco);
            }

            if (empresaDto.getContactos() != null) {
                for (ContactoDto contactoDto : empresaDto.getContactos()) {
                    ContactoRequest contacto = new ContactoRequest();
                    BeanUtils.copyProperties(contactoDto, contacto);
                    contacto.setEmpresaRequest(empresa);
                    contacto.setUserCreate("SYSTEM");
                    empresa.getContactos().add(contacto);
                }
            }


            empresaRepository.saveAndFlush(empresa);

            return new APIResponse.buildAPIResponse()
                    .setStatus(true)
                    .setDetails(Collections.singletonList(empresa))
                    .setStatusText(MessageState.SUCESSO)
                    .builder();
        } catch (Exception e) {
            //e.printStackTrace(); // MOSTRAR erro real no console
            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText(MessageState.ERRO)
                    .setDetails(Collections.singletonList("Erro ao salvar empresa: " + e.getMessage()))
                    .builder();
        }
    }
}
