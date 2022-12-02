package com.chomolungma.system.dict.interfaces.mapstruct;

import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.infrastructure.dataobject.DictDO;
import com.chomolungma.system.dict.interfaces.dto.DictDTO;
import com.chomolungma.system.dict.interfaces.dto.DictPageDTO;
import com.chomolungma.system.dict.interfaces.param.DictParam;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DictEntityMapStruct {
    DictEntityMapStruct INSTANCE = Mappers.getMapper(DictEntityMapStruct.class);

    DictEntity covertToEntity(DictParam dictParam);
    DictDTO toDTO(DictEntity dictEntity);
    @Mappings({
            @Mapping(target = "records", source = "list"),
            @Mapping(target = "page", source = "pageNum")
    })
    DictPageDTO toDTO(PageInfo<DictDO> pageInfo);

}
