package com.isys.erp.service.Impl;

import com.isys.erp.dto.MenuDto;
import com.isys.erp.entity.MenuEntity;
import com.isys.erp.mapper.MenuMapper;
import com.isys.erp.repository.MenuRepository;
import com.isys.erp.service.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuRepository menuRepository;
    @Override
    public ResponseEntity<MenuDto> createMenu(MenuDto menuDto) {
        MenuEntity menuEntity = menuMapper.toEntity(menuDto);
        MenuEntity saveMenu =menuRepository.save(menuEntity);
        MenuDto saveMenuDto =menuMapper.toModel(saveMenu);
        return new ResponseEntity<>(saveMenuDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MenuDto> getMenu(Long id) {
        MenuEntity menuEntity = menuRepository.findById(id).orElse(null);
        if (menuEntity !=null){
            MenuDto menuDto =menuMapper.toModel(menuEntity);
            return ResponseEntity.ok(menuDto);
        }else
            return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<MenuDto>> getAllMenu() {
        List<MenuEntity> menuEntity = menuRepository.findAll();
        return new ResponseEntity<>(menuMapper.toModellist(menuEntity), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MenuDto> updateMenu(Long id, MenuDto menuDto) {
        MenuEntity existingMenu = menuRepository.findById(id).orElse(null);
        if(existingMenu !=null){
            menuMapper.updateEntityFromDto(menuDto, existingMenu);
            MenuEntity updateMenu =menuRepository.save(existingMenu);
            MenuDto updateMenuDto = menuMapper.toModel(updateMenu);
            return new ResponseEntity<>(updateMenuDto, HttpStatus.OK);
        }else
            return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteMenu(Long id) {
        if (menuRepository.existsById(id)) {
            menuRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
