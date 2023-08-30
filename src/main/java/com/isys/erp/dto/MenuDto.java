package com.isys.erp.dto;

import com.isys.erp.entity.RoleEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {


    private Long menuId;
    private String menuName;
    private String parentId;
}
