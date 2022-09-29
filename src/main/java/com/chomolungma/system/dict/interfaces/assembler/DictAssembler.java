package com.chomolungma.system.dict.interfaces.assembler;

import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.interfaces.mapstruct.DictEntityMapStruct;
import com.chomolungma.system.dict.interfaces.param.DictParam;

public class DictAssembler {
    public static DictEntity covertToEntity(DictParam dictParam){
        return DictEntityMapStruct.INSTANCE.covertToEntity(dictParam);
    }
}
