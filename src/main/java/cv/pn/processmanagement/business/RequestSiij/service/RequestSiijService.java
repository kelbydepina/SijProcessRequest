package cv.pn.processmanagement.business.RequestSiij.service;
import cv.pn.processmanagement.business.RequestSiij.RequestSiijDto;
import cv.pn.processmanagement.business.atorRequest.CreateAtorRequestDto;
import cv.pn.processmanagement.business.atorRequest.services.IAtorRequestService;
import cv.pn.processmanagement.business.contatoRequest.ContactoDto;
import cv.pn.processmanagement.business.enderecoRequest.EnderecoDto;
import cv.pn.processmanagement.business.fileRequest.FileRequestDto;
import cv.pn.processmanagement.business.fileRequest.service.IFileRequestService;
import cv.pn.processmanagement.business.identificacao.IdentificacaoDto;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


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

                 // validaçao campo detido
                if (atorDto.getDetido() != null && atorDto.getDetido() ){

                    if (atorDto.getDataDetencao() == null || atorDto.getDataDetencao().trim().isEmpty()) {
                        throw new RuntimeException("Campo 'dataDetencao' é obrigatório quando detido é true");
                    }

                    if (atorDto.getHoraDetencao() == null || atorDto.getHoraDetencao().trim().isEmpty()) {
                        throw new RuntimeException("Campo 'horaDetencao' é obrigatório quando detido é true");
                    }
                }
               

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


                if (atorDto.getPessoa().getNome() == null || atorDto.getPessoa().getNome().trim().isEmpty()
                        || "string".equalsIgnoreCase(atorDto.getPessoa().getNome().trim())) {

                        throw new IllegalStateException("O Campo Nome Pessoa é Obrigatorio.");

                }

                // Melhor prática: criar uma variável para evitar múltiplas chamadas
               /* String nome = atorDto.getPessoa().getNome();

                if (nome == null || nome.trim().isEmpty() || "string".equalsIgnoreCase(nome.trim())) {
                    throw new IllegalStateException("O Campo Nome Pessoa é Obrigatorio.");
                }*/


                // Regras por característica do ator
                if (ehSingular) {
                    var pessoa = atorDto.getPessoa();

                    switch (atorDto.getAtor()) {

                        case DESCONHECIDO:
                            pessoa.setNome("DESCONHECIDO");
                            break;

                        case INDETERMINADO:
                            pessoa.setNome("IDETERMINADO");
                            break;

                        case ANONIMO:
                            pessoa.setNome("ANONIMO");
                            break;

                        case CONHECIDO:

                            if (pessoa.getSexo() == null) {
                                throw new IllegalStateException("Para CONHECIDO, o campo 'sexo' é obrigatório.");
                            }
                            break;
                    }
                }

                if (ehSingular) {
                    var pessoa = atorDto.getPessoa();

                    // validaçao campo endereço
                    if (pessoa.getEndereco() != null) {
                        EnderecoDto endereco = pessoa.getEndereco();

                        if (endereco.getIlha() == null || endereco.getIlha().trim().isEmpty()
                                || "string".equalsIgnoreCase(endereco.getIlha().trim())) {
                            throw new RuntimeException("Campo 'ilha' do endereço é obrigatório");
                        }

                        if (endereco.getConcelho() == null || endereco.getConcelho().trim().isEmpty()
                                || "string".equalsIgnoreCase(endereco.getConcelho().trim())) {
                            throw new RuntimeException("Campo 'concelho' do endereço é obrigatório");
                        }

                        if (endereco.getFreguesia() == null || endereco.getFreguesia().trim().isEmpty()
                                || "string".equalsIgnoreCase(endereco.getFreguesia().trim())) {
                            throw new RuntimeException("Campo 'freguesia' do endereço é obrigatório");
                        }

                        if (endereco.getZona() == null || endereco.getZona().trim().isEmpty()
                                || "string".equalsIgnoreCase(endereco.getZona().trim())) {
                            throw new RuntimeException("Campo 'zona' do endereço é obrigatório");
                        }

                        if (endereco.getLocalidade() == null || endereco.getLocalidade().trim().isEmpty()
                                || "string".equalsIgnoreCase(endereco.getLocalidade().trim())) {
                            throw new RuntimeException("Campo 'localidade' do endereço é obrigatório");
                        }



                        if (endereco.getIdIlha() == null) {
                            throw new RuntimeException("Campo 'idIlha' do endereço é obrigatório");
                        }

                        if (endereco.getIdConcelho() == null) {
                            throw new RuntimeException("Campo 'idConcelho' do endereço é obrigatório");
                        }

                        if (endereco.getIdFreguesia() == null) {
                            throw new RuntimeException("Campo 'idFreguesia' do endereço é obrigatório");
                        }

                        if (endereco.getIdZona() == null) {
                            throw new RuntimeException("Campo 'idZona' do endereço é obrigatório");
                        }

                        if (endereco.getIdLocalidade() == null) {
                            throw new RuntimeException("Campo 'idLocalidade' do endereço é obrigatório");
                        }
                    }

                    // validaçao campo identificaçoes
                    if (pessoa.getIdentificacoes() != null && !pessoa.getIdentificacoes().isEmpty()) {

                        for (IdentificacaoDto identificacao : pessoa.getIdentificacoes()) {

                            if (identificacao.getTipo() == null) {
                                throw new RuntimeException("Campo 'tipo' da identificação é obrigatório");
                            }

                            if (identificacao.getNumero() == null || identificacao.getNumero().trim().isEmpty()
                                    || "string".equalsIgnoreCase(identificacao.getNumero().trim())) {
                                throw new RuntimeException("Campo 'numero' da identificação é obrigatório");
                            }

                            if (identificacao.getPaisEmissor() == null || identificacao.getPaisEmissor().trim().isEmpty()
                                    || "string".equalsIgnoreCase(identificacao.getPaisEmissor().trim())) {
                                throw new RuntimeException("Campo 'paisEmissor' da identificação é obrigatório");
                            }

                            if (identificacao.getEntidadeEmissora() == null || identificacao.getEntidadeEmissora().trim().isEmpty()
                                    || "string".equalsIgnoreCase(identificacao.getEntidadeEmissora().trim())) {
                                throw new RuntimeException("Campo 'entidadeEmissora' da identificação é obrigatório");
                            }

                            if (identificacao.getDataEmissao() == null) {
                                throw new RuntimeException("Campo 'dataEmissao' da identificação é obrigatório");
                            }

                            if (identificacao.getDataValidade() == null) {
                                throw new RuntimeException("Campo 'dataValidade' da identificação é obrigatório");
                            }
                        }
                    }

                     // validaçao campo contactos
                    if (pessoa.getContactos() != null  && !pessoa.getContactos().isEmpty()) {

                        for (ContactoDto contato : pessoa.getContactos()) {

                            if (contato.getTipo() == null || contato.getTipo().trim().isEmpty()
                                    || "string".equalsIgnoreCase(contato.getTipo().trim())) {
                                throw new RuntimeException("Campo 'tipo' do contacto é obrigatório");
                            }

                            if (contato.getContacto() == null || contato.getContacto().trim().isEmpty()
                                    || "string".equalsIgnoreCase(contato.getContacto().trim())) {
                                throw new RuntimeException("Campo 'contacto' é obrigatório");
                            }
                        }
                    }
                }


        }

                APIResponse response = iProcessService.saveProcessStep(dto.getProcess());
                Object detailObj = response.getDetails().get(0);

            if (!(detailObj instanceof ProcessRequest processRequest)) {

                throw new IllegalStateException("Objeto retornado não é do tipo ProcessRequest");
            }

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

           // List<String> errosFiles = new ArrayList<>();

           for (FileRequestDto file: dto.getFiles()) {

               if (file.getTipo() == null || file.getTipo().trim().isEmpty()
                       || "string".equalsIgnoreCase(file.getTipo().trim())) {
                 throw new RuntimeException("Campo 'tipo file' é obrigatório");
                   //errosFiles.add("Campo 'tipo file' é obrigatório");
               }

               if (file.getNumero() == null || file.getNumero().trim().isEmpty()
                       || "string".equalsIgnoreCase(file.getNumero().trim())) {
                   throw new RuntimeException("Campo 'numero file' é obrigatório");
                   //errosFiles.add("Campo 'numero file' é obrigatório");
               }

               if (file.getMineType() == null|| file.getMineType().trim().isEmpty()
                       || "string".equalsIgnoreCase(file.getMineType().trim())) {
                  throw new RuntimeException("Campo 'mineType file' é obrigatório");
                  // errosFiles.add("Campo 'mineType file' é obrigatório");
               }

               if (file.getDescricao() == null || file.getDescricao().trim().isEmpty()
                       || "string".equalsIgnoreCase(file.getDescricao().trim())) {
                   throw new RuntimeException("Campo 'descricao file' é obrigatório");
                   //errosFiles.add("Campo 'descricao file' é obrigatório");
               }

               if (file.getBase64() == null || file.getBase64().trim().isEmpty()
                       || "string".equalsIgnoreCase(file.getBase64().trim())) {
                  throw new RuntimeException("Campo 'base64 file ' é obrigatório");
                  // errosFiles.add("Campo 'base64 file' é obrigatório");
               }
           }

            // Remover duplicados na messagem
            //List<String> errosUnicos = errosFiles.stream().distinct().collect(Collectors.toList());

           /* if (!errosFiles.isEmpty()) {
                return new APIResponse.buildAPIResponse()
                        .setStatus(false)
                        .setStatusText(MessageState.ERRO)
                        .setDetails(Collections.singletonList(errosUnicos))
                        .builder();
            }*/




                 iAtorRequestService.saveAtorRequest(dto.getAtores(), processRequest.getId());

                iFileRequestService.saveAndUpdateFile(dto.getFiles(), processRequest.getId());

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

        if (proc.getTipoCrime() == null || proc.getTipoCrime().trim().isEmpty()
                || "string".equalsIgnoreCase(proc.getTipoCrime().trim())) {
            throw new IllegalStateException("Tipo de crime é obrigatório.");
        }

        // VALIDAÇÃO SIMPLES DO CAMPO COMARCA
        if (proc.getComarcaCode() == null || proc.getComarcaCode().trim().isEmpty()
                || "string".equalsIgnoreCase(proc.getComarcaCode().trim())) {
            throw new IllegalStateException("Campo 'comarcaCode' é obrigatório.");
        }

        //  VALIDAÇÃO DA DESCRIÇÃO DA COMARCA
        if (proc.getComarcaDescription() == null || proc.getComarcaDescription().trim().isEmpty()
                || "string".equalsIgnoreCase(proc.getComarcaDescription().trim())) {
            throw new IllegalStateException("Campo 'comarcaDescription' é obrigatório.");
        }

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


        return proc;
    }


}

