package com.isys.erp.mapper;

import org.mapstruct.Mapper;

import java.util.List;

public  interface BaseMapper <E,M>{
    M toModel(E entity);

    E toEntity(M model);

    List<M> toModellist(List<E> modelList);

    List<E> toEntitylist(List<M> entityList);

}
