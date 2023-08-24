package com.isys.erp.service.Impl;

import com.isys.erp.dto.ApplicationDto;
import com.isys.erp.entity.ApplicationEntity;
import com.isys.erp.mapper.ApplicationMapper;
import com.isys.erp.repository.ApplicationRepository;
import com.isys.erp.service.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public ResponseEntity<ApplicationDto> createApplication(ApplicationDto applicationDto) {
        ApplicationEntity applicationEntity=applicationMapper.toEntity(applicationDto);
        ApplicationEntity saveApplication =applicationRepository.save(applicationEntity);
        ApplicationDto saveApplicationDto =applicationMapper.toModel(saveApplication);
        return new ResponseEntity<>(saveApplicationDto, HttpStatus.OK);
    }
}
