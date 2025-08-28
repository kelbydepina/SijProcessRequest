package cv.pn.processmanagement.business.atorRequest.services;

import cv.pn.processmanagement.business.atorRequest.AtorRequest;
import cv.pn.processmanagement.business.atorRequest.AtorRequestRepository;
import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.business.empressaRequest.EmpresaRequest;
import cv.pn.processmanagement.business.empressaRequest.services.IEmpresaService;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRequest;
import cv.pn.processmanagement.business.pessoaRequest.services.IPessoaRequestService;
import cv.pn.processmanagement.business.processRequest.ProcessRepository;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
public class AtorRequestService implements IAtorRequestService {

    private final AtorRequestRepository atorRequestRepository;

    private final ProcessRepository processRepository;

    private final IPessoaRequestService iPessoaRequestService;

    private final IEmpresaService iEmpresaService;




    public AtorRequestService(AtorRequestRepository atorRequestRepository, ProcessRepository processRepository, IPessoaRequestService iPessoaRequestService, IEmpresaService iEmpresaService) {
        this.atorRequestRepository = atorRequestRepository;
        this.processRepository = processRepository;
        this.iPessoaRequestService = iPessoaRequestService;
        this.iEmpresaService = iEmpresaService;
    }


    @Transactional
    @Override
    public APIResponse saveAtorRequest(CreateAtorRequestDto dto, String processRequest) {
        try {


            ProcessRequest process = processRepository.findById(processRequest)
                    .orElseThrow(() -> new EntityNotFoundException("Processo com ID " + processRequest + " não encontrado"));

            AtorRequest ator = new AtorRequest();

             BeanUtils.copyProperties(dto, ator, "id", "processRequest", "pessoa", "empresa");
            ator.setProcessRequest(process);
            ator.setUserCreate("SYSTEM");

            if (dto.getPessoa() != null) {
                APIResponse pResp = iPessoaRequestService.createPessoa(dto.getPessoa());
                if (pResp == null || !Boolean.TRUE.equals(pResp.getStatus()) ||
                        pResp.getDetails() == null || pResp.getDetails().isEmpty() ||
                        !(pResp.getDetails().get(0) instanceof PessoaRequest)) {

                    return new APIResponse.buildAPIResponse()
                            .setStatus(false)
                            .setStatusText(MessageState.ERRO_SAVE)
                            .setDetails(List.of("Falha ao salvar pessoa do ator"))
                            .builder();
                }

                PessoaRequest pessoa = (PessoaRequest) pResp.getDetails().get(0);
                ator.setPessoaRequest(pessoa);
            }

            if (dto.getEmpresa() != null) {

                APIResponse response = iEmpresaService.createEmpresa(dto.getEmpresa());

                if (response == null || !Boolean.TRUE.equals(response.getStatus()) ||
                response.getDetails() == null || response.getDetails().isEmpty() ||
                !(response.getDetails().get(0) instanceof EmpresaRequest)) {

                    return new APIResponse.buildAPIResponse()
                            .setStatus(false)
                            .setStatusText(MessageState.ERRO_SAVE)
                            .setDetails(List.of("Falha ao salvar Empresa do ator"))
                            .builder();
                }
            }

            atorRequestRepository.save(ator);

            return new APIResponse.buildAPIResponse()
                    .setStatus(true)
                    .setStatusText(MessageState.SUCESSO)
                    .setDetails(List.of(ator))
                    .builder();


        } catch (Exception e) {
            //e.printStackTrace(); // MOSTRAR erro real no console
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

