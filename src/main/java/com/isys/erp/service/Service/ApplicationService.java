package com.isys.erp.service.Service;

import com.isys.erp.dto.ApplicationDto;
import com.isys.erp.entity.ApplicationEntity;
import org.springframework.http.ResponseEntity;

public interface ApplicationService {
    ResponseEntity<ApplicationDto> createApplication (ApplicationDto applicationDto);

    ResponseEntity<ApplicationDto> getApplication(Long id);


}
