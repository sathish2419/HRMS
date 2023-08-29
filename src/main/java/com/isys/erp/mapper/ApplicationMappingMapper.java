package com.isys.erp.mapper;

import com.isys.erp.dto.ApplicationMappingDto;
import com.isys.erp.entity.ApplicationMappingEntity;
import com.isys.erp.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring" ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface ApplicationMappingMapper extends BaseMapper<ApplicationMappingEntity , ApplicationMappingDto> {
    void updateEntityFromDto(ApplicationMappingDto mappingDto, @MappingTarget ApplicationMappingEntity mappingEntity);
}
