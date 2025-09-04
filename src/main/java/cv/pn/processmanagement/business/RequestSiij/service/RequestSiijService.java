package cv.pn.processmanagement.business.RequestSiij.service;
import cv.pn.processmanagement.business.RequestSiij.RequestSiijDto;
import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.business.atorRequest.services.IAtorRequestService;
import cv.pn.processmanagement.business.fileRequest.service.IFileRequestService;
import cv.pn.processmanagement.business.processRequest.CreateProcessDto;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.business.processRequest.ProcessRepository;
import cv.pn.processmanagement.business.processRequest.services.IProcessService;
import cv.pn.processmanagement.enums.ActorsCharacteristics;
import cv.pn.processmanagement.enums.OrigemQueixa;
import cv.pn.processmanagement.enums.PersonType;
import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.stereotype.Service;



import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;




@Service
public class RequestSiijService implements IRequestSiijService {

    private final IAtorRequestService iAtorRequestService;
    private final IProcessService iProcessService;
    private final IFileRequestService iFileRequestService;
    private final ProcessRepository processRepository;

    public RequestSiijService(IAtorRequestService iAtorRequestService, IProcessService iProcessService, IFileRequestService iFileRequestService, ProcessRepository processRepository) {


        this.iAtorRequestService = iAtorRequestService;
        this.iProcessService = iProcessService;
        this.iFileRequestService = iFileRequestService;
        this.processRepository = processRepository;
    }


    @Override
    @Transactional
    public APIResponse saveFullProcess(RequestSiijDto dto) {


        try {


                if (dto == null || dto.getProcess() == null) {
                    return new APIResponse.buildAPIResponse()
                            .setStatus(false)
                            .setStatusText(MessageState.ERRO)
                            .setDetails(List.of("Os dados process é obrigatório."))
                            .builder();
            }

            CreateProcessDto proc = getCreateProcessDto(dto);

            if (proc.getProcurador() == null || proc.getProcurador().trim().isEmpty()
                        || "string".equalsIgnoreCase(proc.getProcurador().trim())) {
                    throw new IllegalStateException("Procurador é obrigatório.");
            }






            if (processRepository.existsByNumeroProcesso(dto.getProcess().getNumeroProcesso())) {
                    return new APIResponse.buildAPIResponse()
                            .setStatus(false)
                            .setDetails(Collections.singletonList("Numero de processo: " + dto.getProcess().getNumeroProcesso() + " ja existe"))
                            .setStatusText(MessageState.ERRO)
                            .builder();
            }

            for (CreateAtorRequestDto atorDto : dto.getAtores()) {

                        boolean ehSingular = atorDto.getTipoPessoa() == PersonType.SINGULAR;
                        boolean colectiva = atorDto.getTipoPessoa() == PersonType.COLECTIVA;

                        String nomePossivel = (atorDto.getPessoa() != null) ? atorDto.getPessoa().getNome() : null;
                        boolean ehDesconhecidoPorEnum  = atorDto.getAtor() == ActorsCharacteristics.DESCONHECIDO;
                        boolean ehDesconhecidoPeloNome = (nomePossivel != null)
                                && !"".equals(nomePossivel.trim())
                                && "DESCONHECIDO".equalsIgnoreCase(nomePossivel.trim());


                if (atorDto.getPessoa() != null && atorDto.getEmpresa() != null) {
                    if (ehSingular) {
                        throw new IllegalStateException("Envie apenas dados de 'pessoa' porque SINGULAR é uma pessoa.");
                    } else if (colectiva) {
                        throw new IllegalStateException("Envie apenas dados de 'empresa' porque COLECTIVA é uma empresa.");
                    } else {
                        throw new IllegalStateException("Envie apenas dados de 'pessoa' OU 'empresa', nunca os dois.");
                    }
                }


                if (ehSingular && atorDto.getPessoa() == null)
                    throw new IllegalStateException("Para tipoPessoa é SINGULAR, os dados 'pessoa' é obrigatório.");

                if (colectiva && atorDto.getEmpresa() == null)
                    throw new IllegalStateException("Para tipoPessoa é COLECTIVA, o dados 'empresa' é obrigatório.");



                if (ehSingular && (ehDesconhecidoPorEnum || ehDesconhecidoPeloNome)) {

                    if (atorDto.getPessoa() == null) {

                            throw new IllegalStateException("Para ator DESCONHECIDO, os dados 'pessoa' sao obrigatório.");
                    }


                    if (atorDto.getPessoa().getSexo() == null) {

                            throw new IllegalStateException("Para pessoa DESCONHECIDA, o campo 'sexo' é obrigatório.");
                    }



                    String df = atorDto.getPessoa().getDescricaoFisica();
                    if (df == null || df.trim().isEmpty()) {


                        throw new IllegalStateException("Para pessoa DESCONHECIDA, o campo 'descricaoFisica' é obrigatório.");
                    }


                    String nome = atorDto.getPessoa().getNome();
                    if (nome == null || nome.trim().isEmpty() || !nome.equalsIgnoreCase("DESCONHECIDO")) {

                            atorDto.getPessoa().setNome("DESCONHECIDO");
                    }
                }

            }

                APIResponse response = iProcessService.saveProcessStep(dto.getProcess());
                Object detailObj = response.getDetails().get(0);

            if (!(detailObj instanceof ProcessRequest)) {

                throw new IllegalStateException("Objeto retornado não é do tipo ProcessRequest");
            }

                ProcessRequest processRequest = (ProcessRequest) detailObj;

            if (dto.getAtores() == null || dto.getAtores().isEmpty()) {

                    return new APIResponse.buildAPIResponse()
                            .setStatus(false)
                            .setStatusText(MessageState.ERRO)
                            .setDetails(Collections.singletonList("Os dados do Autor é Obrigatorio "))
                            .builder();
            }

            if (dto.getFiles() == null || dto.getFiles().isEmpty()) {

                    return new APIResponse.buildAPIResponse()
                            .setStatus(false)
                            .setStatusText(MessageState.ERRO)
                            .setDetails(Collections.singletonList("Os dados do Arquivo é Obrigatorio "))
                            .builder();
            }

                 iAtorRequestService.saveAtorRequest(dto.getAtores(), ((ProcessRequest) detailObj).getId());

                iFileRequestService.saveAndUpdateFile(dto.getFiles(), ((ProcessRequest) detailObj).getId());

                    return new APIResponse.buildAPIResponse()
                            .setStatus(true)
                            .setStatusText(MessageState.SUCESSO)
                            .setDetails(List.of(processRequest.getIdentificadorProcesso()))
                            .builder();



        } catch (Exception e) {

                    return new APIResponse.buildAPIResponse()
                            .setStatus(false)
                            .setStatusText(MessageState.ERRO_SAVE)
                            .setDetails(Collections.singletonList(e.getMessage()))
                            .builder();

        }

    }

    private static CreateProcessDto getCreateProcessDto(RequestSiijDto dto) {

        CreateProcessDto proc = dto.getProcess();

        if (proc.getOrigemQueixa() != null && proc.getOrigemQueixa() == OrigemQueixa.PN) {

            if (proc.getNumeroReferencia() == null || proc.getNumeroReferencia().trim().isEmpty()
                    || "string".equalsIgnoreCase(proc.getNumeroReferencia().trim())) {
                throw new IllegalStateException(
                        "O campo 'numeroReferencia' é obrigatório quando origemQueixa é PN.");
            }

            if (proc.getOrganica() == null || proc.getOrganica().trim().isEmpty()
                    || "string".equalsIgnoreCase(proc.getOrganica().trim())) {
                throw new IllegalStateException(
                        "O campo 'organica' é obrigatório quando origemQueixa é PN.");
            }
        }

        if (proc.getTipoCrime() == null || proc.getTipoCrime().trim().isEmpty()
                || "string".equalsIgnoreCase(proc.getTipoCrime().trim())) {
            throw new IllegalStateException("Tipo de crime é obrigatório.");
        }
        return proc;
    }


}

