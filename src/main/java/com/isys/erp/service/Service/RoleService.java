package com.isys.erp.service.Service;

import com.isys.erp.dto.RoleDto;

import org.springframework.http.ResponseEntity;

public interface RoleService {
    ResponseEntity<RoleDto> createRole(RoleDto roledto);

    ResponseEntity<RoleDto> getById(Long roleId);

    ResponseEntity<RoleDto> updateRole(Long roleId, RoleDto roleDto);

    String deleteRoleById(Long roleId);


    ResponseEntity<Void> deleteRole(Long roleId);
}
