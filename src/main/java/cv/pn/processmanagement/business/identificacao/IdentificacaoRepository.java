package cv.pn.processmanagement.business.identificacao;

import cv.pn.processmanagement.business.pessoaRequest.PessoaRequest;
import cv.pn.processmanagement.enums.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IdentificacaoRepository extends JpaRepository<IdentificacaoRequest, String> {
    boolean existsByTipoAndNumeroAndPessoaRequest(DocumentType tipo, String numero, PessoaRequest pessoaRequest);

    Optional<IdentificacaoRequest> findByTipoAndNumeroAndPessoaRequest(DocumentType tipo, String numero, PessoaRequest pessoaRequest);

    List<IdentificacaoRequest> findByPessoaRequest(PessoaRequest pessoaRequest);
}
