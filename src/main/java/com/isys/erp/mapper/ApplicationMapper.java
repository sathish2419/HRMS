package com.isys.erp.mapper;

import com.isys.erp.dto.ApplicationDto;
import com.isys.erp.entity.ApplicationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ApplicationMapper extends BaseMapper<ApplicationEntity, ApplicationDto>{
    void updateEntityFromDto(ApplicationDto dto, @MappingTarget ApplicationEntity entity);


}
