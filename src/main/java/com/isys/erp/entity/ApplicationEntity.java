package com.isys.erp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "application", schema = "isys_erp")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_code")
    private String applicationCode;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private boolean status = true;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "created_date")
    @CreationTimestamp
    private Date createdDate = new Date();

    @Column(name = "updated_date")
    @UpdateTimestamp
    private Date updatedDate = new Date();
}
