package com.chomolungma.system.dict.interfaces.assembler;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.interfaces.dto.DictDTO;
import com.chomolungma.system.dict.interfaces.dto.DictPageDTO;
import com.chomolungma.system.dict.interfaces.param.DictParam;
import com.chomolungma.system.dict.interfaces.mapstruct.DictEntityMapStruct;

public class DictAssembler {
    public static DictEntity covertToEntity(DictParam dictParam){
        return DictEntityMapStruct.INSTANCE.covertToEntity(dictParam);
    }

    public static DictPageDTO covertToDTO(IPage<DictEntity> iPage){
        return DictEntityMapStruct.INSTANCE.covertToDTO(iPage);
    }

    public static DictDTO covertToDictDTO(DictEntity dictEntity){
        return DictEntityMapStruct.INSTANCE.convertToDictDTO(dictEntity);
    }
}
