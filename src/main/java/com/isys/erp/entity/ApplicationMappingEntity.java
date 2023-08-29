package com.isys.erp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applicationMapping" , schema = "isys_erp")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApplicationMappingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long linkId;

    @Column(name = "application_code")
    private String applicationCode;

    @Column(name = "company_code")
    private String companyCode;

}
