package com.chomolungma.system.resource.infrastructure.converter;

import com.chomolungma.system.resource.domain.entity.ResourceEntity;
import com.chomolungma.system.resource.infrastructure.dataobject.ResourceDO;
import com.chomolungma.system.resource.interfaces.dto.ResourcePageDTO;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResourceConverter {
    ResourceConverter INSTANCE = Mappers.getMapper(ResourceConverter.class);

    ResourceDO toDO(ResourceEntity resourceEntity);

    ResourceEntity toEntity(ResourceDO resourceDO);

    @Mappings({
            @Mapping(target = "records", source = "list"),
            @Mapping(target = "page", source = "pageNum")
    })
    ResourcePageDTO toDTO(PageInfo<ResourceDO> pageInfo);
}
