package com.isys.erp.controller;

import com.isys.erp.dto.ApplicationDto;
import com.isys.erp.service.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {   //one

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/createApplication")
    public ResponseEntity<ApplicationDto> createApplication (@RequestBody ApplicationDto applicationDto){
        return  applicationService.createApplication(applicationDto);
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
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ApplicationDto> applicationPage = applicationService.getAllApplications(pageable);
        return ResponseEntity.ok(applicationPage);
    }

    @GetMapping("/Applications")
    public ResponseEntity<Page<ApplicationDto>> getAllApplications(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1") int size,
            @RequestParam(defaultValue = "applicationName") String sortBy,
            @RequestParam() String filterName)

    {

        return applicationService.getAllApplications(page, size, sortBy, filterName);
    }


}
