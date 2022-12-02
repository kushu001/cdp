package com.chomolungma.system.dict.interfaces.mapstruct;

import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.infrastructure.dataobject.DictItemDO;
import com.chomolungma.system.dict.interfaces.dto.DictItemDTO;
import com.chomolungma.system.dict.interfaces.dto.DictItemPageDTO;
import com.chomolungma.system.dict.interfaces.param.DictItemParam;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DictItemEntityMapStruct {
    DictItemEntityMapStruct INSTANCE = Mappers.getMapper(DictItemEntityMapStruct.class);
    DictItemEntity covertToEntity(DictItemParam dictItemParam);

    DictItemDTO toDTO(DictItemEntity dictItemEntity);

    List<DictItemDTO> toDTO(List<DictItemDO> dictItemDOS);

    @Mappings({
            @Mapping(target = "records", source = "list"),
            @Mapping(target = "page", source = "pageNum")
    })
    DictItemPageDTO toDTO(PageInfo<DictItemDO> pageInfo);
}
