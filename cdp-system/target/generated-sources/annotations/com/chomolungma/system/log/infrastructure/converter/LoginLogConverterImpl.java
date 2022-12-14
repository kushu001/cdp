package com.chomolungma.system.log.infrastructure.converter;

import com.chomolungma.system.log.domain.entity.LoginLogEntity;
import com.chomolungma.system.log.infrastructure.dataobject.LoginLogDO;
import com.chomolungma.system.log.interfaces.dto.LoginLogDTO;
import java.util.Date;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class LoginLogConverterImpl implements LoginLogConverter {

    @Override
    public LoginLogDO toDO(LoginLogEntity loginLogEntity) {
        if ( loginLogEntity == null ) {
            return null;
        }

        LoginLogDO loginLogDO = new LoginLogDO();

        loginLogDO.setId( loginLogEntity.getId() );
        if ( loginLogEntity.getCreateTime() != null ) {
            loginLogDO.setCreateTime( Date.from( loginLogEntity.getCreateTime() ) );
        }
        if ( loginLogEntity.getUpdateTime() != null ) {
            loginLogDO.setUpdateTime( Date.from( loginLogEntity.getUpdateTime() ) );
        }
        loginLogDO.setCreateUser( loginLogEntity.getCreateUser() );
        loginLogDO.setUpdateUser( loginLogEntity.getUpdateUser() );
        loginLogDO.setStatus( loginLogEntity.getStatus() );
        loginLogDO.setUser( loginLogEntity.getUser() );
        loginLogDO.setAddress( loginLogEntity.getAddress() );
        loginLogDO.setClient( loginLogEntity.getClient() );
        loginLogDO.setOs( loginLogEntity.getOs() );
        loginLogDO.setIp( loginLogEntity.getIp() );

        return loginLogDO;
    }

    @Override
    public LoginLogDO toDO(LoginLogDTO loginLogDTO) {
        if ( loginLogDTO == null ) {
            return null;
        }

        LoginLogDO loginLogDO = new LoginLogDO();

        loginLogDO.setId( loginLogDTO.getId() );
        loginLogDO.setCreateTime( loginLogDTO.getCreateTime() );
        loginLogDO.setUpdateTime( loginLogDTO.getUpdateTime() );
        loginLogDO.setCreateUser( loginLogDTO.getCreateUser() );
        loginLogDO.setUpdateUser( loginLogDTO.getUpdateUser() );
        loginLogDO.setStatus( loginLogDTO.getStatus() );
        loginLogDO.setUser( loginLogDTO.getUser() );
        loginLogDO.setAddress( loginLogDTO.getAddress() );
        loginLogDO.setClient( loginLogDTO.getClient() );
        loginLogDO.setOs( loginLogDTO.getOs() );
        loginLogDO.setIp( loginLogDTO.getIp() );

        return loginLogDO;
    }

    @Override
    public LoginLogEntity toEntity(LoginLogDO loginLogDO) {
        if ( loginLogDO == null ) {
            return null;
        }

        LoginLogEntity loginLogEntity = new LoginLogEntity();

        loginLogEntity.setId( loginLogDO.getId() );
        if ( loginLogDO.getCreateTime() != null ) {
            loginLogEntity.setCreateTime( loginLogDO.getCreateTime().toInstant() );
        }
        if ( loginLogDO.getUpdateTime() != null ) {
            loginLogEntity.setUpdateTime( loginLogDO.getUpdateTime().toInstant() );
        }
        loginLogEntity.setCreateUser( loginLogDO.getCreateUser() );
        loginLogEntity.setUpdateUser( loginLogDO.getUpdateUser() );
        loginLogEntity.setStatus( loginLogDO.getStatus() );
        loginLogEntity.setUser( loginLogDO.getUser() );
        loginLogEntity.setAddress( loginLogDO.getAddress() );
        loginLogEntity.setIp( loginLogDO.getIp() );
        loginLogEntity.setClient( loginLogDO.getClient() );
        loginLogEntity.setOs( loginLogDO.getOs() );

        return loginLogEntity;
    }
}
