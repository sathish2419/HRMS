package com.isys.erp.service.Impl;


import com.isys.erp.dto.RoleDto;
import com.isys.erp.entity.RoleEntity;
import com.isys.erp.mapper.RoleMapper;
import com.isys.erp.repository.RoleRepository;
import com.isys.erp.service.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleRepository roleRepository;

    public RoleServiceImpl() {
    }

    @Override
    public ResponseEntity<RoleDto> createRole(RoleDto roleDto) {
        RoleEntity roleEntity = roleMapper.toEntity(roleDto);
        RoleEntity saveRole = roleRepository.save(roleEntity);
        RoleDto saveRoleDto = roleMapper.toModel(saveRole);
        return new ResponseEntity<>(saveRoleDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RoleDto> getById(Long roleId) {
        RoleEntity roleEntity = roleRepository.findById(roleId).orElse(null);
        if (roleEntity != null) {
            RoleDto roleDto = roleMapper.toModel(roleEntity);
            return ResponseEntity.ok(roleDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<RoleDto> updateRole(Long roleId, RoleDto roleDto) {
        RoleEntity existingRole = roleRepository.findById(roleId).orElse(null);
        if(existingRole!=null){
            roleMapper.updateEntityFromDto(roleDto,existingRole);
            RoleEntity updatedRole=roleRepository.save(existingRole);
            RoleDto updatedRoleDto=roleMapper.toModel(updatedRole);
            return ResponseEntity.ok(updatedRoleDto);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    public String deleteRoleById(Long roleId) {
        roleRepository.deleteById(roleId);
        return "Id deleted successfully";
    }


}
