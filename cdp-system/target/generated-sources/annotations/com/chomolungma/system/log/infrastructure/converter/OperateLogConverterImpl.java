package com.chomolungma.system.log.infrastructure.converter;

import com.chomolungma.system.log.domain.entity.OperateLogEntity;
import com.chomolungma.system.log.infrastructure.dataobject.OperateLogDO;
import com.chomolungma.system.log.interfaces.dto.OperateLogDTO;
import java.util.Date;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class OperateLogConverterImpl implements OperateLogConverter {

    @Override
    public OperateLogDO toDO(OperateLogEntity operateLogEntity) {
        if ( operateLogEntity == null ) {
            return null;
        }

        OperateLogDO operateLogDO = new OperateLogDO();

        operateLogDO.setId( operateLogEntity.getId() );
        if ( operateLogEntity.getCreateTime() != null ) {
            operateLogDO.setCreateTime( Date.from( operateLogEntity.getCreateTime() ) );
        }
        if ( operateLogEntity.getUpdateTime() != null ) {
            operateLogDO.setUpdateTime( Date.from( operateLogEntity.getUpdateTime() ) );
        }
        operateLogDO.setCreateUser( operateLogEntity.getCreateUser() );
        operateLogDO.setUpdateUser( operateLogEntity.getUpdateUser() );
        operateLogDO.setStatus( operateLogEntity.getStatus() );
        operateLogDO.setUser( operateLogEntity.getUser() );
        operateLogDO.setUrl( operateLogEntity.getUrl() );
        operateLogDO.setRequestMethod( operateLogEntity.getRequestMethod() );
        operateLogDO.setResourceName( operateLogEntity.getResourceName() );
        operateLogDO.setPathPayload( operateLogEntity.getPathPayload() );
        operateLogDO.setPayload( operateLogEntity.getPayload() );

        return operateLogDO;
    }

    @Override
    public OperateLogDO toDO(OperateLogDTO operateLogDTO) {
        if ( operateLogDTO == null ) {
            return null;
        }

        OperateLogDO operateLogDO = new OperateLogDO();

        operateLogDO.setId( operateLogDTO.getId() );
        operateLogDO.setCreateTime( operateLogDTO.getCreateTime() );
        operateLogDO.setUpdateTime( operateLogDTO.getUpdateTime() );
        operateLogDO.setCreateUser( operateLogDTO.getCreateUser() );
        operateLogDO.setUpdateUser( operateLogDTO.getUpdateUser() );
        operateLogDO.setStatus( operateLogDTO.getStatus() );
        operateLogDO.setUser( operateLogDTO.getUser() );
        operateLogDO.setUrl( operateLogDTO.getUrl() );
        operateLogDO.setRequestMethod( operateLogDTO.getRequestMethod() );
        operateLogDO.setResourceName( operateLogDTO.getResourceName() );
        operateLogDO.setPathPayload( operateLogDTO.getPathPayload() );
        operateLogDO.setPayload( operateLogDTO.getPayload() );

        return operateLogDO;
    }

    @Override
    public OperateLogEntity toEntity(OperateLogDO operateLogDO) {
        if ( operateLogDO == null ) {
            return null;
        }

        OperateLogEntity operateLogEntity = new OperateLogEntity();

        operateLogEntity.setId( operateLogDO.getId() );
        if ( operateLogDO.getCreateTime() != null ) {
            operateLogEntity.setCreateTime( operateLogDO.getCreateTime().toInstant() );
        }
        if ( operateLogDO.getUpdateTime() != null ) {
            operateLogEntity.setUpdateTime( operateLogDO.getUpdateTime().toInstant() );
        }
        operateLogEntity.setCreateUser( operateLogDO.getCreateUser() );
        operateLogEntity.setUpdateUser( operateLogDO.getUpdateUser() );
        operateLogEntity.setStatus( operateLogDO.getStatus() );
        operateLogEntity.setUser( operateLogDO.getUser() );
        operateLogEntity.setUrl( operateLogDO.getUrl() );
        operateLogEntity.setRequestMethod( operateLogDO.getRequestMethod() );
        operateLogEntity.setResourceName( operateLogDO.getResourceName() );
        operateLogEntity.setPathPayload( operateLogDO.getPathPayload() );
        operateLogEntity.setPayload( operateLogDO.getPayload() );

        return operateLogEntity;
    }
}
