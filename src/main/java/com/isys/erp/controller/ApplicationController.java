package com.isys.erp.controller;

import com.isys.erp.dto.ApplicationDto;
import com.isys.erp.service.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/save")
    public ResponseEntity<ApplicationDto> createApplication (@RequestBody ApplicationDto applicationDto){
        return  applicationService.createApplication(applicationDto);
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<ApplicationDto> getApplication(@PathVariable Long id) {
        return applicationService.getApplication(id);
    }

}
