package cv.pn.processmanagement.business.atorRequest.services;
import cv.pn.processmanagement.business.atorRequest.AtorRequest;
import cv.pn.processmanagement.business.atorRequest.AtorRequestRepository;
import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.business.empressaRequest.EmpresaRequest;
import cv.pn.processmanagement.business.empressaRequest.services.IEmpresaService;
import cv.pn.processmanagement.business.fileRequest.FileRequest;
import cv.pn.processmanagement.business.fileRequest.FileRequestDto;
import cv.pn.processmanagement.business.pessoaRequest.PessoaDto;
import cv.pn.processmanagement.business.pessoaRequest.PessoaRequest;
import cv.pn.processmanagement.business.pessoaRequest.services.IPessoaRequestService;
import cv.pn.processmanagement.business.processRequest.ProcessRepository;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.enums.ActorsCharacteristics;
import cv.pn.processmanagement.enums.PersonType;
import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AtorRequestService implements IAtorRequestService {


    private static final int MIN_DESC_CHARS = 10;
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

            List<AtorRequest>  actor =  atoresDtos
                    .stream()
                    .map(atores -> {

                        AtorRequest ator = new AtorRequest();
                        BeanUtils.copyProperties(atores, ator);

                        ator.setUserCreate("SYSTEM");

                        APIResponse pResp = iPessoaRequestService.createPessoa(atores.getPessoa());

                        PessoaRequest pessoa = (PessoaRequest) pResp.getDetails().get(0);
                        ator.setPessoaRequest(pessoa);

                        APIResponse eResp = iEmpresaService.createEmpresa(atores.getEmpresa());

                        EmpresaRequest empresa = (EmpresaRequest) eResp.getDetails().get(0);
                        ator.setEmpresaRequest(empresa);

                        atorRequestRepository.saveAndFlush(ator);

                        return ator;

                    }).collect(Collectors.toList());

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








