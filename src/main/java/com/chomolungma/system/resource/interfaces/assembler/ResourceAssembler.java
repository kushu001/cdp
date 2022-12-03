package com.chomolungma.system.resource.interfaces.assembler;

import com.chomolungma.system.resource.domain.entity.ResourceEntity;
import com.chomolungma.system.resource.interfaces.dto.ResourceDTO;
import com.chomolungma.system.resource.interfaces.mapstruct.ResourceEntityMapStruct;
import com.chomolungma.system.resource.interfaces.param.ResourceParam;

public final class ResourceAssembler {
    public static ResourceEntity toEntity(ResourceParam resourceParam){
        return ResourceEntityMapStruct.INSTANCE.toEntity(resourceParam);
    }

    public static ResourceDTO toDTO(ResourceEntity resourceEntity){
        return ResourceEntityMapStruct.INSTANCE.toDTO(resourceEntity);
    }
}
