package com.chomolungma.system.dict.interfaces.mapstruct;

import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.interfaces.dto.DictItemDTO;
import com.chomolungma.system.dict.interfaces.param.DictItemParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DictItemEntityMapStruct {
    DictItemEntityMapStruct INSTANCE = Mappers.getMapper(DictItemEntityMapStruct.class);
    DictItemEntity covertToEntity(DictItemParam dictItemParam);

    DictItemDTO toDTO(DictItemEntity dictItemEntity);
}
