package com.isys.erp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role_table")

public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  Long roleId;
    @Column(name = "Role_Code")
    private String roleCode;
    @Column(name = "Role_Name")
    private String roleName;
    @Column(name = "Role_Description")
    private String roleDescription;
}
