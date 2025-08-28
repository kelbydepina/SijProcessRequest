package cv.pn.processmanagement.business.empressaRequest.services;

import cv.pn.processmanagement.business.empressaRequest.EmpresaDto;
import cv.pn.processmanagement.business.empressaRequest.EmpresaRepository;
import cv.pn.processmanagement.business.empressaRequest.EmpresaRequest;
import cv.pn.processmanagement.utilities.APIResponse;

import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class EmpresaService implements IEmpresaService{

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }


    @Override
    public APIResponse createEmpresa(EmpresaDto empresaDto) {

        try {

            EmpresaRequest empresa = new EmpresaRequest();

            BeanUtils.copyProperties(empresaDto, empresa);
            empresa.setUserCreate("SYSTEM");
            empresaRepository.save(empresa);

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
