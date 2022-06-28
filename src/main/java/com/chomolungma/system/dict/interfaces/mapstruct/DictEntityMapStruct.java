package com.chomolungma.system.dict.interfaces.mapstruct;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.interfaces.dto.DictDTO;
import com.chomolungma.system.dict.interfaces.dto.DictPageDTO;
import com.chomolungma.system.dict.interfaces.param.DictParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DictEntityMapStruct {
    DictEntityMapStruct INSTANCE = Mappers.getMapper(DictEntityMapStruct.class);

    DictEntity covertToEntity(DictParam dictParam);

    DictPageDTO covertToDTO(IPage<DictEntity> iPage);

    DictDTO convertToDictDTO(DictEntity dictEntity);
}
