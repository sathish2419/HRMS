package com.isys.erp.dto;

import com.isys.erp.entity.MenuEntity;
import lombok.*;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleDto {
    private Long roleId;
    private String roleName;
    private String roleCode;
    private String roleDescription;
    private List<MenuDto> menus;



}
