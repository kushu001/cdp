package com.chomolungma.system.dict.infrastructure.converter;

import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.infrastructure.dataobject.DictDO;
import com.chomolungma.system.dict.interfaces.dto.DictPageDTO;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DictConverter {
    DictConverter INSTANCE = Mappers.getMapper(DictConverter.class);

    @Mappings({
            @Mapping(target = "records", source = "list"),
            @Mapping(target = "page", source = "pageNum")
    })
    DictPageDTO toDTO(PageInfo<DictDO> pageInfo);

    DictEntity toEntity(DictDO dictDO);

    DictDO toDO(DictEntity dictEntity);
}
