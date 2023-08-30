package com.isys.erp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role_table",schema = "isys_erp")

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

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "role_menu",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "menu_id")}
    )
    private List<MenuEntity> menus;
}
