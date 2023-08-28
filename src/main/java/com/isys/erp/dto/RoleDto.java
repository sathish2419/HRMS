package com.isys.erp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleDto {
    private Long roleId;
    private String roleName;
    private String roleCode;
    private String roleDescription;
}
