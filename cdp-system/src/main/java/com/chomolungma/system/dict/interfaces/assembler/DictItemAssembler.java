package com.chomolungma.system.dict.interfaces.assembler;

import com.chomolungma.system.dict.infrastructure.dataobject.DictItemDO;
import com.chomolungma.system.dict.interfaces.mapstruct.DictItemEntityMapStruct;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.interfaces.dto.DictItemDTO;
import com.chomolungma.system.dict.interfaces.dto.DictItemPageDTO;
import com.chomolungma.system.dict.interfaces.param.DictItemParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class DictItemAssembler {
    public static DictItemEntity covertToEntity(DictItemParam dictItemParam){
        return DictItemEntityMapStruct.INSTANCE.covertToEntity(dictItemParam);
    }

    public static DictItemDTO toDTO(DictItemEntity dictItemEntity){
        return DictItemEntityMapStruct.INSTANCE.toDTO(dictItemEntity);
    }

    public static List<DictItemDTO> toDTO(List<DictItemDO> dictItemDOS){
        return DictItemEntityMapStruct.INSTANCE.toDTO(dictItemDOS);
    }

    public static DictItemPageDTO toDTO(PageInfo<DictItemDO> pageInfo){
        return DictItemEntityMapStruct.INSTANCE.toDTO(pageInfo);
    }
}
