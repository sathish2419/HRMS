package com.isys.erp.controller;

import com.isys.erp.dto.ApplicationMappingDto;
import com.isys.erp.service.Service.ApplicationMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApplicationMappingController {
    @Autowired
    private ApplicationMappingService applicationMappingService;

    @PostMapping("/create")
    public ResponseEntity<ApplicationMappingDto> createApplicationMapping (@RequestBody ApplicationMappingDto applicationMappingDto){
        return  applicationMappingService.createApplicationMapping(applicationMappingDto);
    }
    @GetMapping("/applicationMapping/{id}")
    public ResponseEntity<ApplicationMappingDto> getAllApplicationMapping(@PathVariable Long id){
        return applicationMappingService.getAllApplicationMapping(id);
    }
    @GetMapping("/applicationMappings")
    public ResponseEntity<List<ApplicationMappingDto>> getAllApplicationMappings(){
        return applicationMappingService.getAllApplicationMappings();
    }
    @PutMapping("/applicationMappings/{id}")
    public ResponseEntity<ApplicationMappingDto> updateApplicationMapping(@PathVariable Long id, @RequestBody ApplicationMappingDto applicationMappingDto){
        return applicationMappingService.updateApplicationMapping(id , applicationMappingDto);
    }

    @DeleteMapping("/applicationMappings/{id}")
    public ResponseEntity<String> deleteApplicationMappingById(@PathVariable Long id){
        ResponseEntity<Void> response = applicationMappingService.deleteApplicationMappingById(id);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Application deleted successfully.");
        } else {
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }
}
