/*package cv.pn.processmanagement.business.contatoRequest.services;


import cv.pn.processmanagement.business.contatoRequest.ContactoDto;
import cv.pn.processmanagement.business.contatoRequest.ContactoRepository;

import cv.pn.processmanagement.business.contatoRequest.ContactoRequest;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class ContactoService implements IContactoService{

    private final ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }


    @Override
    public List<ContactoRequest> processarContactos(List<ContactoDto> contactos, PessoaRequest pessoaRequest) {
        if (pessoaRequest == null || contactos == null || contactos.isEmpty()) {

            return Collections.emptyList();
        }

        List<ContactoRequest> result = new ArrayList<>();

        for (ContactoDto dto : contactos) {
            ContactoRequest ent = new ContactoRequest();
            BeanUtils.copyProperties(dto, ent);
            ent.setPessoaRequest(pessoaRequest);
            ent.setUserCreate("SYSTEM");

            pessoaRequest.getContactos().add(ent);
            result.add(ent);
        }



        return result;
    }
}*/
