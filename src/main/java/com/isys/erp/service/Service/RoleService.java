package com.isys.erp.service.Service;

import com.isys.erp.dto.RoleDto;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RoleService {
    ResponseEntity<RoleDto> createRole(RoleDto roledto);

    ResponseEntity<RoleDto> getById(Long roleId);

    ResponseEntity<RoleDto> updateRole(Long roleId, RoleDto roleDto);


    ResponseEntity<Void> deleteRole(Long roleId);

    ResponseEntity<List<RoleDto>> getAllRole();
}
