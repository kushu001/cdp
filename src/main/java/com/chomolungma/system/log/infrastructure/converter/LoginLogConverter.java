package com.chomolungma.system.log.infrastructure.converter;

import com.chomolungma.system.log.domain.entity.LoginLogEntity;
import com.chomolungma.system.log.infrastructure.dataobject.LoginLogDO;
import com.chomolungma.system.log.interfaces.dto.LoginLogDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoginLogConverter {
    LoginLogConverter INSTANCE = Mappers.getMapper(LoginLogConverter.class);

    LoginLogDO toDO(LoginLogEntity loginLogEntity);

    LoginLogDO toDO(LoginLogDTO loginLogDTO);

    LoginLogEntity toEntity(LoginLogDO loginLogDO);


}
