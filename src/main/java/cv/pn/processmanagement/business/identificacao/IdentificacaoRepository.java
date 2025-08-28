package cv.pn.processmanagement.business.identificacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentificacaoRepository extends JpaRepository<IdentificacaoRequest, String> {
}
