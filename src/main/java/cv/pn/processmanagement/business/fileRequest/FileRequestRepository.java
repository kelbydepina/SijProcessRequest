package cv.pn.processmanagement.business.fileRequest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.File;

import java.util.List;

public interface FileRequestRepository extends JpaRepository<FileRequest, String> {

    List<FileRequest> findAllByProcessRequestId(String relationTable);

}
