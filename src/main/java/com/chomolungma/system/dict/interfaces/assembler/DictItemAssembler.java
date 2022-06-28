package com.chomolungma.system.dict.interfaces.assembler;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.interfaces.dto.DictItemDTO;
import com.chomolungma.system.dict.interfaces.dto.DictItemPageDTO;
import com.chomolungma.system.dict.interfaces.mapstruct.DictItemEntityMapStruct;
import com.chomolungma.system.dict.interfaces.param.DictItemParam;

public class DictItemAssembler {
    public static DictItemEntity covertToEntity(DictItemParam dictItemParam){
        return DictItemEntityMapStruct.INSTANCE.covertToEntity(dictItemParam);
    }


    public static DictItemPageDTO covertToDTO(IPage<DictItemEntity> iPage){
        return DictItemEntityMapStruct.INSTANCE.covertToDTO(iPage);
    }

    public static DictItemDTO covertToDTO(DictItemEntity dictItem){
        return DictItemEntityMapStruct.INSTANCE.convertToDictDTO(dictItem);
    }
}
