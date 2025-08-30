package cv.pn.processmanagement.business.atorRequest.services;
import cv.pn.processmanagement.business.atorRequest.AtorRequest;
import cv.pn.processmanagement.business.atorRequest.AtorRequestRepository;
import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.business.empressaRequest.EmpresaRequest;
import cv.pn.processmanagement.business.empressaRequest.services.IEmpresaService;
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
    public APIResponse saveAtorRequest(CreateAtorRequestDto dto, String processRequest) {


        try {


                if (dto == null) return erro(" os dados  ator é obrigatório.");
                if (dto.getTipoPessoa() == null)
                    return erro("O campo 'tipoPessoa' é obrigatório (SINGULAR ou COLECTIVA).");

                // Busca o processo (garante process_fk não nulo)
                ProcessRequest process = processRepository.findById(processRequest)
                        .orElseThrow(() -> new EntityNotFoundException("Processo com ID " + processRequest + " não encontrado"));

                boolean singular  = dto.getTipoPessoa() == PersonType.SINGULAR;
                boolean colectiva = dto.getTipoPessoa() == PersonType.COLECTIVA;



                if (dto.getPessoa() != null && dto.getEmpresa() != null) {
                    if (singular) {
                        return erro("Envie apenas dados de 'pessoa' porque SINGULAR é uma pessoa.");
                    } else if (colectiva) {
                        return erro("Envie apenas dados de 'empresa' porque COLECTIVA é uma empresa.");
                    } else {
                        return erro("Envie apenas dados de 'pessoa' OU 'empresa', nunca os dois.");
                    }
                }



                if (singular && dto.getPessoa() == null)
                    return erro("Para tipoPessoa é SINGULAR, os dados 'pessoa' é obrigatório.");
                if (colectiva && dto.getEmpresa() == null)
                    return erro("Para tipoPessoa é COLECTIVA, o dados 'empresa' é obrigatório.");



                if (singular && dto.getAtor() == ActorsCharacteristics.DESCONHECIDO) {
                    PessoaDto p = dto.getPessoa(); // já garantido != null
                    // 1) sexo obrigatório (enum)
                    if (p.getSexo() == null) {
                        return erro("Para pessoa DESCONHECIDA, o campo 'sexo' é obrigatório.");
                    }
                    // 2) descricaoFisica: texto real (mín. 10 chars e não placeholders)
                    if (isDescricaoInvalida(p.getDescricaoFisica())) {
                        return erro("Para pessoa DESCONHECIDA, 'descricaoFisica' é obrigatória e deve descrever a pessoa ");
                    }
                    // 3) nome sempre forçado para "DESCONHECIDO"
                    p.setNome("DESCONHECIDO");
                }



                AtorRequest ator = new AtorRequest();
                BeanUtils.copyProperties(dto, ator, "id", "processRequest", "pessoa", "empresa");
                ator.setProcessRequest(process);
                ator.setUserCreate("SYSTEM");


                if (singular) {
                    APIResponse pResp = iPessoaRequestService.createPessoa(dto.getPessoa());
                    if (pResp == null || !Boolean.TRUE.equals(pResp.getStatus())
                            || pResp.getDetails() == null || pResp.getDetails().isEmpty()
                            || !(pResp.getDetails().get(0) instanceof PessoaRequest)) {
                        return erro("Falha ao salvar Pessoa do ator.");
                    }
                    PessoaRequest pessoa = (PessoaRequest) pResp.getDetails().get(0);
                    ator.setPessoaRequest(pessoa);
                } else { // COLECTIVA
                    APIResponse eResp = iEmpresaService.createEmpresa(dto.getEmpresa());
                    if (eResp == null || !Boolean.TRUE.equals(eResp.getStatus())
                            || eResp.getDetails() == null || eResp.getDetails().isEmpty()
                            || !(eResp.getDetails().get(0) instanceof EmpresaRequest)) {
                        return erro("Falha ao salvar Empresa do ator.");
                    }
                    EmpresaRequest empresa = (EmpresaRequest) eResp.getDetails().get(0);
                    ator.setEmpresaRequest(empresa);
                }


                atorRequestRepository.saveAndFlush(ator);

                return ok(ator);

        } catch (Exception e) {
            return erro("Erro ao salvar ator: " + e.getMessage());
        }


    }

        private boolean isDescricaoInvalida(String descricaoFisica) {
            if (descricaoFisica.length() < 10) return true;
            String t = descricaoFisica.trim();
            if (t.length() < MIN_DESC_CHARS) return true;
            String low = t.toLowerCase();

            return low.equals("string") || low.equals("descricao") || low.equals("descrição")
                    || low.equals("n/a") || low.equals("na") || low.equals("-") || low.equals("desconhecido");
    }


        private APIResponse ok(Object d) {
            return new APIResponse.buildAPIResponse()
                    .setStatus(true)
                    .setStatusText(MessageState.SUCESSO)
                    .setDetails(List.of(d))
                    .builder();
    }

        private APIResponse erro(String m) {
            return new APIResponse.buildAPIResponse()
                    .setStatus(false)
                    .setStatusText(MessageState.ERRO)
                    .setDetails(Collections.singletonList(m))
                    .builder();
    }
}








