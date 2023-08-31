package com.isys.erp.service.Impl;

import com.isys.erp.dto.MenuDto;
import com.isys.erp.dto.RoleDto;
import com.isys.erp.entity.MenuEntity;
import com.isys.erp.entity.RoleEntity;
import com.isys.erp.mapper.MenuMapper;
import com.isys.erp.mapper.RoleMapper;
import com.isys.erp.repository.MenuRepository;
import com.isys.erp.repository.RoleRepository;
import com.isys.erp.service.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuMapper menuMapper;

    public RoleServiceImpl() {
    }

    @Override
    public ResponseEntity<RoleDto> createRole(RoleDto roleDto) {
        RoleEntity roleEntity = roleMapper.toEntity(roleDto);

        // Persist menu entities first
        List<MenuEntity> persistedMenus = new ArrayList<>();
        for (MenuDto menuDto : roleDto.getMenus()) {
            MenuEntity menuEntity = menuMapper.toEntity(menuDto);
            menuRepository.save(menuEntity);
            persistedMenus.add(menuEntity);
        }

        roleEntity.setMenus(persistedMenus);

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
        if (existingRole != null) {
            roleMapper.updateEntityFromDto(roleDto, existingRole);

            List<MenuEntity> updatedMenuEntities = new ArrayList<>();
            for (MenuDto menuDto : roleDto.getMenus()) {
                MenuEntity menuEntity = menuRepository.findById(menuDto.getMenuId()).orElse(null);
                if (menuEntity != null) {
                    // Update existing menu data here
                    menuEntity.setMenuName(menuDto.getMenuName());
                    menuEntity.setParentId(menuDto.getParentId()); // Set parent ID if applicable
                    updatedMenuEntities.add(menuEntity);
                } else {
                    // Use the MenuMapper to convert MenuDto to MenuEntity
                    MenuEntity newMenuEntity = menuMapper.toEntity(menuDto);
                    updatedMenuEntities.add(newMenuEntity);
                }
            }

            existingRole.setMenus(updatedMenuEntities);

            RoleEntity updatedRole = roleRepository.save(existingRole);
            RoleDto updatedRoleDto = roleMapper.toModel(updatedRole);
            return ResponseEntity.ok(updatedRoleDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @Override
    public String deleteRoleById(Long roleId) {
        roleRepository.deleteById(roleId);
        return "Id deleted successfully";
    }

    @Override
    public ResponseEntity<Void> deleteRole(Long roleId) {//delete
        if (roleRepository.existsById(roleId)) {
            roleRepository.deleteById(roleId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    public ResponseEntity<List<RoleDto>> getAllRole() {
        List<RoleEntity> roleEntity = roleRepository.findAll();
        return new ResponseEntity<>(roleMapper.toModellist(roleEntity), HttpStatus.OK);
    }
}
