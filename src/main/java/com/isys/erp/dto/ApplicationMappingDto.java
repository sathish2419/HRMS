package com.isys.erp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationMappingDto {


    private Long linkId;
    private String applicationCode;
    private String companyCode;
}
