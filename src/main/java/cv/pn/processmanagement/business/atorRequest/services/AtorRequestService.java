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
    public APIResponse saveAtorRequest(List<CreateAtorRequestDto> atoresDtos, String processRequest) {


        try {


            ProcessRequest process = processRepository.findById(processRequest)
                    .orElseThrow(() -> new javax.persistence.EntityNotFoundException("Processo com ID " + processRequest + " não encontrado"));



            List<AtorRequest>  actor =  atoresDtos
                    .stream()
                    .map(atores -> {

                            AtorRequest ator = new AtorRequest();
                            BeanUtils.copyProperties(atores, ator, "id", "processRequest", "pessoa", "empresa");

                            ator.setUserCreate("SYSTEM");

                            /*ProcessRequest process = processRepository.findById(processRequest)
                                    .orElseThrow(() -> new javax.persistence.EntityNotFoundException("Processo com ID " + processRequest + " não encontrado"));*/

                            ator.setProcessRequest(process);



                        // Se veio PESSOA, salva e associa
                        if (atores.getPessoa() != null) {
                                APIResponse pResp = iPessoaRequestService.createPessoa(atores.getPessoa());
                                if (pResp == null || !Boolean.TRUE.equals(pResp.getStatus())
                                        || pResp.getDetails() == null || pResp.getDetails().isEmpty()
                                        || !(pResp.getDetails().get(0) instanceof PessoaRequest pessoa)) {
                                    throw new IllegalStateException("Falha ao salvar pessoa do ator.");
                            }
                            ator.setPessoaRequest(pessoa);
                        }

                        // Se veio EMPRESA, salva e associa
                        if (atores.getEmpresa() != null) {
                                APIResponse eResp = iEmpresaService.createEmpresa(atores.getEmpresa());
                                if (eResp == null || !Boolean.TRUE.equals(eResp.getStatus())
                                        || eResp.getDetails() == null || eResp.getDetails().isEmpty()
                                        || !(eResp.getDetails().get(0) instanceof EmpresaRequest empresa)) {
                                    throw new IllegalStateException("Falha ao salvar empresa do ator.");
                            }
                            ator.setEmpresaRequest(empresa);
                        }

                        if (atores.getPessoa() == null && atores.getEmpresa() == null) {

                                throw new IllegalStateException("Envie 'pessoa' ou 'empresa' para o ator.");
                        }

                        // Salva o ATOR já com FKs definidas
                            atorRequestRepository.saveAndFlush(ator);

                        /*APIResponse pResp = iPessoaRequestService.createPessoa(atores.getPessoa());

                        PessoaRequest pessoa = (PessoaRequest) pResp.getDetails().get(0);
                        ator.setPessoaRequest(pessoa);

                        APIResponse eResp = iEmpresaService.createEmpresa(atores.getEmpresa());

                        EmpresaRequest empresa = (EmpresaRequest) eResp.getDetails().get(0);
                        ator.setEmpresaRequest(empresa);

                        atorRequestRepository.saveAndFlush(ator);

                        return ator;*/

                        return ator;

                    }).toList();

            return new APIResponse.buildAPIResponse()
                    .setStatus(true)
                    .setStatusText(MessageState.SUCESSO)
                    .setDetails(Collections.singletonList(actor))
                    .builder();


        } catch (Exception e) {
            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText(MessageState.ERRO)
                    .builder();
        }


    }
}








