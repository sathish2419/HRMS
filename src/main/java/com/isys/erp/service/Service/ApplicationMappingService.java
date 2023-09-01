package com.isys.erp.service.Service;

import com.isys.erp.dto.ApplicationMappingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApplicationMappingService {


    ResponseEntity<ApplicationMappingDto> createApplicationMapping(ApplicationMappingDto applicationMappingDto);

    ResponseEntity<ApplicationMappingDto> getAllApplicationMapping(Long id);

    ResponseEntity<List<ApplicationMappingDto>> getAllApplicationMappings();

    ResponseEntity<ApplicationMappingDto> updateApplicationMapping(Long id, ApplicationMappingDto applicationMappingDto);


    ResponseEntity<Void> deleteApplicationMappingById(Long id);

    Page<ApplicationMappingDto> getAllApplicationsMappings(Pageable pageable);
}
