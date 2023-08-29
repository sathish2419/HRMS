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

    @PostMapping("/createApplicationMapping")
    public ResponseEntity<ApplicationMappingDto> createApplicationMapping (@RequestBody ApplicationMappingDto applicationMappingDto){
        return  applicationMappingService.createApplicationMapping(applicationMappingDto);
    }
    @GetMapping("/getByIdApplicationMapping/{id}")
    public ResponseEntity<ApplicationMappingDto> getAllApplicationMapping(@PathVariable Long id){
        return applicationMappingService.getAllApplicationMapping(id);
    }
    @GetMapping("/getAllApplicationMapping")
    public ResponseEntity<List<ApplicationMappingDto>> getAllApplicationMappings(){
        return applicationMappingService.getAllApplicationMappings();
    }
    @PutMapping("/updateApplicationMapping/{id}")
    public ResponseEntity<ApplicationMappingDto> updateApplicationMapping(@PathVariable Long id, @RequestBody ApplicationMappingDto applicationMappingDto){
        return applicationMappingService.updateApplicationMapping(id , applicationMappingDto);
    }

    @DeleteMapping("/deleteApplicationMapping/{id}")
    public ResponseEntity<String> deleteApplicationMappingById(@PathVariable Long id){
        ResponseEntity<Void> response = applicationMappingService.deleteApplicationMappingById(id);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Application deleted successfully.");
        } else {
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }
}
