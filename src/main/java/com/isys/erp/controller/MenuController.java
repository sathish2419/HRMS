package com.isys.erp.controller;

import com.isys.erp.dto.ApplicationDto;
import com.isys.erp.dto.MenuDto;
import com.isys.erp.entity.ApplicationEntity;
import com.isys.erp.entity.MenuEntity;
import com.isys.erp.service.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/menuCreate")
    public ResponseEntity<MenuDto> createMenu(@RequestBody MenuDto menuDto){
        return menuService.createMenu(menuDto);
    }
    @GetMapping("/getByIdMenu/{id}")
    public ResponseEntity<MenuDto> getMenu(@PathVariable Long id){
        return menuService.getMenu(id);
    }
    @GetMapping("/getAllMenu")
    public ResponseEntity<List<MenuDto>> getAllMenu(){
        return menuService.getAllMenu();
    }

    @PutMapping("/updateMenu/{id}")
    public ResponseEntity<MenuDto> updateMenu(@PathVariable Long id, @RequestBody MenuDto menuDto){
        return menuService.updateMenu(id, menuDto);
    }
    @DeleteMapping("/deleteMenu/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable Long id) {
        ResponseEntity<Void> response = menuService.deleteMenu(id);

        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Menu deleted successfully.");
        } else {
            return ResponseEntity.status(response.getStatusCode()).build();
        }
    }

    @GetMapping("/paginationMenu")
    public ResponseEntity<Page<MenuDto>> getAllMenus(
            @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<MenuDto> menuPage = menuService.getAllmenus(pageable);
        return ResponseEntity.ok(menuPage);
    }
    @GetMapping("/sortingMenu")
    public Page<MenuEntity> getPaginationAndSortingMenu(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "menuName") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        return menuService.getPaginationAndSortingMenu(page, 2, sortBy, sortOrder);
    }



}
