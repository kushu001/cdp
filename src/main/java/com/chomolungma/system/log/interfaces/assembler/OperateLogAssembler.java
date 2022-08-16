package com.chomolungma.system.log.interfaces.assembler;

import com.chomolungma.system.log.domain.entity.OperateLogEntity;
import com.chomolungma.system.log.domain.repository.dataobject.OperateLogDO;
import com.chomolungma.system.log.interfaces.dto.OperateLogDTO;
import com.chomolungma.system.log.interfaces.dto.OperateLogPageDTO;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperateLogAssembler {
    OperateLogAssembler INSTANCE = Mappers.getMapper(OperateLogAssembler.class);

    OperateLogEntity toEntity(OperateLogDTO operateLogDTO);

    OperateLogDTO toDTO(OperateLogEntity operateLogEntity);

    @Mappings({
            @Mapping(target = "records", source = "list"),
            @Mapping(target = "page", source = "pageNum")
    })
    OperateLogPageDTO toPageDTO(PageInfo<OperateLogDO> pageInfo);
}
