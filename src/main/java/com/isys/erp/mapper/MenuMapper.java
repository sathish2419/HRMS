package com.isys.erp.mapper;


import com.isys.erp.dto.MenuDto;
import com.isys.erp.entity.MenuEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MenuMapper extends BaseMapper<MenuEntity, MenuDto> {

    void updateEntityFromDto(MenuDto menuDto,@MappingTarget MenuEntity existingMenu);
}
