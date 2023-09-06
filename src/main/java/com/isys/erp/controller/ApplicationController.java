package com.isys.erp.controller;

import com.isys.erp.dto.ApplicationDto;
import com.isys.erp.entity.ApplicationEntity;
import com.isys.erp.service.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/createApplication")
    public ResponseEntity<ApplicationDto> createApplication(@RequestBody ApplicationDto applicationDto) {
        return applicationService.createApplication(applicationDto);
    }

    @GetMapping("/getByIdApplication/{id}")
    public ResponseEntity<ApplicationDto> getApplication(@PathVariable Long id) {
        return applicationService.getApplication(id);
    }

    @GetMapping("/getAllApplication")
    public ResponseEntity<List<ApplicationDto>> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @PutMapping("/updateApplication/{id}")
    public ResponseEntity<ApplicationDto> updateApplication(@PathVariable Long id, @RequestBody ApplicationDto applicationDto) {
        return applicationService.updateApplication(id, applicationDto);
    }

    @DeleteMapping("/deleteApplication/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
        ResponseEntity<Void> response = applicationService.deleteApplication(id);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Application deleted successfully.");
        } else {
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }

    @GetMapping("/paginationApplication")
    public ResponseEntity<Page<ApplicationDto>> getAllApplications(
            @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<ApplicationDto> applicationPage = applicationService.getAllApplications(pageable);
        return ResponseEntity.ok(applicationPage);
    }


    @GetMapping("/Applications")
    public Page<ApplicationEntity> getPaginationAndSortingApplication(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "applicationName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        return applicationService.getPaginationAndSortingApplication(page, 2, sortBy, sortOrder);
    }


}
