package com.chomolungma.system.dict.interfaces.assembler;

import com.chomolungma.system.dict.infrastructure.dataobject.DictDO;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.interfaces.dto.DictDTO;
import com.chomolungma.system.dict.interfaces.dto.DictPageDTO;
import com.chomolungma.system.dict.interfaces.mapstruct.DictEntityMapStruct;
import com.chomolungma.system.dict.interfaces.param.DictParam;
import com.github.pagehelper.PageInfo;

public class DictAssembler {
    public static DictEntity covertToEntity(DictParam dictParam){
        return DictEntityMapStruct.INSTANCE.covertToEntity(dictParam);
    }

    public static DictDTO toDTO(DictEntity dictEntity){
        return DictEntityMapStruct.INSTANCE.toDTO(dictEntity);
    }

    public static DictPageDTO toDTO(PageInfo<DictDO> pageInfo){
        return DictEntityMapStruct.INSTANCE.toDTO(pageInfo);
    }
}
