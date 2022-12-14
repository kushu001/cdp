package com.chomolungma.system.dict.infrastructure.converter;

import com.chomolungma.system.dict.infrastructure.dataobject.DictDO;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DictConverter {
    DictConverter INSTANCE = Mappers.getMapper(DictConverter.class);

    DictEntity toEntity(DictDO dictDO);

    DictDO toDO(DictEntity dictEntity);
}
