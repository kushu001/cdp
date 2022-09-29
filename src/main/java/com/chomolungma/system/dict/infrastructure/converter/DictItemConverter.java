package com.chomolungma.system.dict.infrastructure.converter;

import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.infrastructure.dataobject.DictItemDO;
import com.chomolungma.system.dict.interfaces.dto.DictItemPageDTO;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DictItemConverter {
    DictItemConverter INSTANCE = Mappers.getMapper(DictItemConverter.class);

    @Mappings({
            @Mapping(target = "records", source = "list"),
            @Mapping(target = "page", source = "pageNum")
    })
    DictItemPageDTO toDTO(PageInfo<DictItemDO> pageInfo);

    DictItemEntity toEntity(DictItemDO dictItemDO);

    List<DictItemEntity> toEntity(List<DictItemDO> dictItemDOS);

    DictItemDO toDO(DictItemEntity dictItemEntity);
}
