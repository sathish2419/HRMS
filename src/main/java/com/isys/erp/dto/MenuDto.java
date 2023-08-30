package com.isys.erp.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {

    private Long menuId;
    private String menuName;
    private String parentId;
    private ApplicationDto application;
}
