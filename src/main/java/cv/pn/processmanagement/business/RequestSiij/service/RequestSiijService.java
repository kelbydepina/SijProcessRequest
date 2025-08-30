package cv.pn.processmanagement.business.RequestSiij.service;
import cv.pn.processmanagement.business.RequestSiij.RequestSiijDto;
import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.business.atorRequest.services.IAtorRequestService;
import cv.pn.processmanagement.business.fileRequest.service.IFileRequestService;
import cv.pn.processmanagement.business.pessoaRequest.PessoaDto;
import cv.pn.processmanagement.business.processRequest.ProcessRequest;
import cv.pn.processmanagement.business.processRequest.ProcessRepository;
import cv.pn.processmanagement.business.processRequest.services.IProcessService;
import cv.pn.processmanagement.enums.ActorsCharacteristics;
import cv.pn.processmanagement.enums.PersonType;
import cv.pn.processmanagement.utilities.APIResponse;
import cv.pn.processmanagement.utilities.MessageState;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


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
                            .setDetails(List.of("O objeto process é obrigatório."))
                            .builder();
            }

                if (processRepository.existsByNumeroProcesso(dto.getProcess().getNumeroProcesso())) {
                    return new APIResponse.buildAPIResponse()
                            .setStatus(false)
                            .setDetails(Collections.singletonList("Numero de processo: " + dto.getProcess().getNumeroProcesso() + " ja existe"))
                            .setStatusText(MessageState.ERRO)
                            .builder();
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



            for (CreateAtorRequestDto atorDto : dto.getAtores()) {

                    boolean ehSingular = atorDto.getTipoPessoa() == PersonType.SINGULAR;

                    String nomePossivel = (atorDto.getPessoa() != null) ? atorDto.getPessoa().getNome() : null;
                    boolean ehDesconhecidoPorEnum  = atorDto.getAtor() == ActorsCharacteristics.DESCONHECIDO;
                    boolean ehDesconhecidoPeloNome = (nomePossivel != null)
                            && !"".equals(nomePossivel.trim())
                            && "DESCONHECIDO".equalsIgnoreCase(nomePossivel.trim());

                if (ehSingular && (ehDesconhecidoPorEnum || ehDesconhecidoPeloNome)) {

                    if (atorDto.getPessoa() == null) {

                            throw new IllegalStateException("Para ator=DESCONHECIDO, o objeto 'pessoa' é obrigatório.");
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



                APIResponse aResp = iAtorRequestService.saveAtorRequest(atorDto, processRequest.getId());
                if (!Boolean.TRUE.equals(aResp.getStatus())) {

                        throw new IllegalStateException(firstDetail(aResp.getDetails()));
                }
            }


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

    private String firstDetail(List<Object> details) {
            if (details == null || details.isEmpty()) return "Erro ao salvar ator.";
            Object d0 = details.get(0);
            return (d0 == null) ? "Erro ao salvar ator." : String.valueOf(d0);
    }


}

