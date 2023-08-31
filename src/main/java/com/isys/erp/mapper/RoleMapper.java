package com.isys.erp.mapper;

import com.isys.erp.dto.MenuDto;
import com.isys.erp.dto.RoleDto;
import com.isys.erp.entity.MenuEntity;
import com.isys.erp.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface RoleMapper extends BaseMapper<RoleEntity, RoleDto> {
    void updateEntityFromDto(RoleDto dto, @MappingTarget RoleEntity entity);

    default List<MenuEntity> mapMenuDtoListToMenuEntityList(List<MenuDto> menuDtos) {
        return menuDtos.stream()
                .map(menuDto -> {
                    MenuEntity menuEntity = new MenuEntity();
                    menuEntity.setMenuId(menuDto.getMenuId());
                    menuEntity.setMenuName(menuDto.getMenuName());
                    menuEntity.setParentId(menuDto.getParentId());
                    return menuEntity;
                })
                .collect(Collectors.toList());
    }

    default List<MenuDto> mapMenuEntityListToMenuDtoList(List<MenuEntity> menuEntities) {
        return menuEntities.stream()
                .map(menuEntity -> {
                    MenuDto menuDto = new MenuDto();
                    menuDto.setMenuId(menuEntity.getMenuId());
                    menuDto.setMenuName(menuEntity.getMenuName());
                    menuDto.setParentId(menuEntity.getParentId());
                    return menuDto;
                })
                .collect(Collectors.toList());
    }
}
