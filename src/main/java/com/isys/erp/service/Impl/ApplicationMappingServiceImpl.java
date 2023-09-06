package com.isys.erp.service.Impl;


import com.isys.erp.dto.ApplicationMappingDto;
import com.isys.erp.entity.ApplicationMappingEntity;
import com.isys.erp.mapper.ApplicationMappingMapper;
import com.isys.erp.repository.ApplicationMappingRepository;
import com.isys.erp.service.Service.ApplicationMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ApplicationMappingServiceImpl implements ApplicationMappingService {
    @Autowired
    private ApplicationMappingMapper applicationMappingMapper;
    @Autowired
    private ApplicationMappingRepository applicationMappingRepository;


    @Override
    public ResponseEntity<ApplicationMappingDto> createApplicationMapping(ApplicationMappingDto applicationMappingDto) {
        ApplicationMappingEntity applicationMappingEntity = applicationMappingMapper.toEntity(applicationMappingDto);
        ApplicationMappingEntity saveApplicationMapping = applicationMappingRepository.save(applicationMappingEntity);
        ApplicationMappingDto saveApplicationMappingDto = applicationMappingMapper.toModel(saveApplicationMapping);
        return new ResponseEntity<>(saveApplicationMappingDto, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ApplicationMappingDto> getAllApplicationMapping(Long id) {
        ApplicationMappingEntity applicationMappingEntity = applicationMappingRepository.findById(id).orElse(null);
        if (applicationMappingEntity != null) {
            ApplicationMappingDto applicationMappingDto = applicationMappingMapper.toModel(applicationMappingEntity);
            return ResponseEntity.ok(applicationMappingDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<ApplicationMappingDto>> getAllApplicationMappings() {
        List<ApplicationMappingEntity> applicationMappingEntity = applicationMappingRepository.findAll();
        return new ResponseEntity<>(applicationMappingMapper.toModellist(applicationMappingEntity), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApplicationMappingDto> updateApplicationMapping(Long id, ApplicationMappingDto applicationMappingDto) {
        ApplicationMappingEntity existingApplicationMapping = applicationMappingRepository.findById(id).orElse(null);
        if(existingApplicationMapping != null){
            applicationMappingMapper.updateEntityFromDto(applicationMappingDto,existingApplicationMapping);
            ApplicationMappingEntity updateApplicationMapping = applicationMappingRepository.save(existingApplicationMapping);
            ApplicationMappingDto updateApplicationMappingDto = applicationMappingMapper.toModel(updateApplicationMapping);
            return ResponseEntity.ok(updateApplicationMappingDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteApplicationMappingById(Long id) {
        if(applicationMappingRepository.existsById(id)){
            applicationMappingRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public Page<ApplicationMappingDto> getAllApplicationsMappings(Pageable pageable) {
        Page<ApplicationMappingEntity> applicationMappingPage = applicationMappingRepository.findAll(pageable);
        return applicationMappingPage.map(applicationMappingMapper::toModel);

    }

    @Override
    public Page<ApplicationMappingEntity> getApplicationsMappings(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        PageRequest pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return applicationMappingRepository.findAll(pageable);
    }

}
