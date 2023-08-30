package com.isys.erp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Menu", schema = "isys_erp")
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "menu_id")
    private Long menuId;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "parent_id")
    private String parentId;

    @ManyToOne
    private ApplicationEntity application;
}
