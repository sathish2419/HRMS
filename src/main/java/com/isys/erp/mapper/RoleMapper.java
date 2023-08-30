package com.isys.erp.mapper;

import com.isys.erp.dto.RoleDto;
import com.isys.erp.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface RoleMapper extends BaseMapper<RoleEntity, RoleDto> {
    void updateEntityFromDto(RoleDto dto, @MappingTarget RoleEntity entity);
}
