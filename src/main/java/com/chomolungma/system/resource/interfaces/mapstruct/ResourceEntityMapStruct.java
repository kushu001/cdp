package com.chomolungma.system.resource.interfaces.mapstruct;

import com.chomolungma.system.resource.domain.entity.ResourceEntity;
import com.chomolungma.system.resource.interfaces.param.ResourceParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResourceEntityMapStruct {
    ResourceEntityMapStruct INSTANCE = Mappers.getMapper(ResourceEntityMapStruct.class);

    ResourceEntity toEntity(ResourceParam resourceParam);
}
