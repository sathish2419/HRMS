package com.isys.erp.service.Service;

import com.isys.erp.dto.ApplicationDto;
import com.isys.erp.entity.ApplicationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApplicationService {
    ResponseEntity<ApplicationDto> createApplication (ApplicationDto applicationDto);

    ResponseEntity<ApplicationDto> getApplication(Long id);

    ResponseEntity<List<ApplicationDto>> getAllApplications();

    ResponseEntity<ApplicationDto> updateApplication(Long id, ApplicationDto applicationDto);

    ResponseEntity<Void> deleteApplication(Long id);

    
     Page<ApplicationDto> getAllApplications(Pageable pageable);


    Page<ApplicationEntity> getPaginationAndSortingApplication(int page, int i, String sortBy, String sortOrder);
}
