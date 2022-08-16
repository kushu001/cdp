package com.chomolungma.system.log.domain.repository.converter;

import com.chomolungma.system.log.domain.entity.OperateLogEntity;
import com.chomolungma.system.log.domain.repository.dataobject.OperateLogDO;
import com.chomolungma.system.log.interfaces.dto.OperateLogDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperateLogConverter {
    OperateLogConverter INSTANCE = Mappers.getMapper(OperateLogConverter.class);

    OperateLogDO toDO(OperateLogEntity operateLogEntity);

    OperateLogDO toDO(OperateLogDTO operateLogDTO);

    OperateLogEntity toEntity(OperateLogDO operateLogDO);


}
