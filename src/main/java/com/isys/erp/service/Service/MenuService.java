package com.isys.erp.service.Service;

import com.isys.erp.dto.MenuDto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface MenuService {
    ResponseEntity<MenuDto> createMenu(MenuDto menuDto);

    ResponseEntity<MenuDto> getMenu(Long id);

    ResponseEntity<List<MenuDto>> getAllMenu();

    ResponseEntity<MenuDto> updateMenu(Long id, MenuDto menuDto);


    ResponseEntity<Void> deleteMenu(Long id);
}
