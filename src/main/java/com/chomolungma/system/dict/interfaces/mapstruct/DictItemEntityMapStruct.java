package com.chomolungma.system.dict.interfaces.mapstruct;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.interfaces.dto.DictItemDTO;
import com.chomolungma.system.dict.interfaces.dto.DictItemPageDTO;
import com.chomolungma.system.dict.interfaces.param.DictItemParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DictItemEntityMapStruct {
    DictItemEntityMapStruct INSTANCE = Mappers.getMapper(DictItemEntityMapStruct.class);
    DictItemEntity covertToEntity(DictItemParam dictItemParam);

    DictItemPageDTO covertToDTO(IPage<DictItemEntity> iPage);

    DictItemDTO convertToDictDTO(DictItemEntity dictItemEntity);
}
