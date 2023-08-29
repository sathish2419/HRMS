package com.isys.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDto {

    private Long id;
    private String applicationCode;
    private String applicationName;
    private String description;
    private String createdBy;
    private String updatedBy;




}
