package cv.pn.processmanagement.business.processRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessRepository extends JpaRepository<ProcessRequest, String> {

    // Paginação de todos os processos
    Page<ProcessRequest> findAll(Pageable pageable);

    boolean existsByIdentifierProcess(String identifierProcess);
    boolean existsByProcessNumber(String processNumber);

    // Buscar processo pelo identificador único
    ProcessRequest findByIdentifierProcess(String identifierProcess);

    List<ProcessRequest> findTopByOrderByIdentifierProcessDesc();

    //Se quiser consultas por fase, status, tipo de crime etc.
    /*List<Process> findAllByStatusCode(String statusCode);
    List<Process> findAllByProcessPhaseCode(String processPhaseCode);
    List<Process> findAllByCrimeTypeCode(String crimeTypeCode);*/
}
