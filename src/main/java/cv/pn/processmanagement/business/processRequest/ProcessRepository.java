package cv.pn.processmanagement.business.processRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessRepository extends JpaRepository<ProcessRequest, String> {

    // Paginação de todos os processos
    Page<ProcessRequest> findAll(Pageable pageable);

   // boolean existsByIdentificadorProcesso(String identifierProcess);
    boolean existsByNumeroProcesso(String numeroProcesso);

    // Buscar processo pelo identificador único
    boolean findByIdentificadorProcesso(String identifierProcess);

    List<ProcessRequest> findTopByOrderByIdentificadorProcessoDesc();


}
