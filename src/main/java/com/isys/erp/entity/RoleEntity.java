package com.isys.erp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "Role_Code")
    private String roleCode;
    @Column(name = "Role_Name")
    private String roleName;
    @Column(name = "Role_Description")
    private String roleDescription;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "role_menu", // name of the join table
            joinColumns = @JoinColumn(name = "role_id"), // foreign key column for RoleEntity
            inverseJoinColumns = @JoinColumn(name = "menu_id") // foreign key column for MenuEntity
    )
    private List<MenuEntity> menus = new ArrayList<>();
}
