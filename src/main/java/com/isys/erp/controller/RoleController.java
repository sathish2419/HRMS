package com.isys.erp.controller;

import com.isys.erp.dto.ApplicationDto;
import com.isys.erp.dto.RoleDto;

import com.isys.erp.entity.RoleEntity;
import com.isys.erp.service.Service.RoleService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")

public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/createRole")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) {
        return roleService.createRole(roleDto);
    }
    @GetMapping("/getAllRole")
    public ResponseEntity<List<RoleDto>> getAllRole() {
        return roleService.getAllRole();
    }
    @GetMapping("/role/{roleId}")
    public ResponseEntity<RoleDto> getById(@PathVariable Long roleId) {
        return roleService.getById(roleId);
    }

    @PutMapping("/updateRole/{roleId}")
    public ResponseEntity<RoleDto> updateRole(@PathVariable Long roleId,
                                              @RequestBody RoleDto roleDto) {
        ResponseEntity<RoleDto> updateRole = roleService.updateRole(roleId, roleDto);
        return updateRole;
    }

    @DeleteMapping("/deleteRole/{roleId}")
    public ResponseEntity<String> deleteRole(@PathVariable Long roleId) {
        ResponseEntity<Void> response = roleService.deleteRole(roleId);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Role deleted successfully.");
        } else {
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }
}