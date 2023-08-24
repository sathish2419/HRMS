package com.isys.erp.controller;

import com.isys.erp.dto.ApplicationDto;
import com.isys.erp.service.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/applications")
    public ResponseEntity<List<ApplicationDto>> getAllApplications() {
        return applicationService.getAllApplications();
    }
    @PutMapping("/applications/{id}")
    public ResponseEntity<ApplicationDto> updateApplication(@PathVariable Long id, @RequestBody ApplicationDto applicationDto) {
        return applicationService.updateApplication(id, applicationDto);
    }

    @DeleteMapping("/applications/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
        ResponseEntity<Void> response = applicationService.deleteApplication(id);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Application deleted successfully.");
        } else {
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }

}
