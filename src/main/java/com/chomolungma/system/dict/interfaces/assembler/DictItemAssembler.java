package com.chomolungma.system.dict.interfaces.assembler;

import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.interfaces.dto.DictItemDTO;
import com.chomolungma.system.dict.interfaces.mapstruct.DictItemEntityMapStruct;
import com.chomolungma.system.dict.interfaces.param.DictItemParam;

public class DictItemAssembler {
    public static DictItemEntity covertToEntity(DictItemParam dictItemParam){
        return DictItemEntityMapStruct.INSTANCE.covertToEntity(dictItemParam);
    }

    public static DictItemDTO toDTO(DictItemEntity dictItemEntity){
        return DictItemEntityMapStruct.INSTANCE.toDTO(dictItemEntity);
    }
}
