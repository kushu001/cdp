package com.chomolungma.system.log.interfaces.assembler;

import com.chomolungma.system.log.domain.entity.LoginLogEntity;
import com.chomolungma.system.log.infrastructure.dataobject.LoginLogDO;
import com.chomolungma.system.log.interfaces.dto.LoginLogDTO;
import com.chomolungma.system.log.interfaces.dto.LoginLogPageDTO;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class LoginLogAssemblerImpl implements LoginLogAssembler {

    @Override
    public LoginLogEntity toEntity(LoginLogDTO loginLogDTO) {
        if ( loginLogDTO == null ) {
            return null;
        }

        LoginLogEntity loginLogEntity = new LoginLogEntity();

        loginLogEntity.setId( loginLogDTO.getId() );
        if ( loginLogDTO.getCreateTime() != null ) {
            loginLogEntity.setCreateTime( loginLogDTO.getCreateTime().toInstant() );
        }
        if ( loginLogDTO.getUpdateTime() != null ) {
            loginLogEntity.setUpdateTime( loginLogDTO.getUpdateTime().toInstant() );
        }
        loginLogEntity.setCreateUser( loginLogDTO.getCreateUser() );
        loginLogEntity.setUpdateUser( loginLogDTO.getUpdateUser() );
        loginLogEntity.setStatus( loginLogDTO.getStatus() );
        loginLogEntity.setUser( loginLogDTO.getUser() );
        loginLogEntity.setAddress( loginLogDTO.getAddress() );
        loginLogEntity.setIp( loginLogDTO.getIp() );
        loginLogEntity.setClient( loginLogDTO.getClient() );
        loginLogEntity.setOs( loginLogDTO.getOs() );

        return loginLogEntity;
    }

    @Override
    public LoginLogDTO toDTO(LoginLogEntity loginLogEntity) {
        if ( loginLogEntity == null ) {
            return null;
        }

        LoginLogDTO loginLogDTO = new LoginLogDTO();

        loginLogDTO.setId( loginLogEntity.getId() );
        if ( loginLogEntity.getCreateTime() != null ) {
            loginLogDTO.setCreateTime( Date.from( loginLogEntity.getCreateTime() ) );
        }
        if ( loginLogEntity.getUpdateTime() != null ) {
            loginLogDTO.setUpdateTime( Date.from( loginLogEntity.getUpdateTime() ) );
        }
        loginLogDTO.setCreateUser( loginLogEntity.getCreateUser() );
        loginLogDTO.setUpdateUser( loginLogEntity.getUpdateUser() );
        loginLogDTO.setStatus( loginLogEntity.getStatus() );
        loginLogDTO.setUser( loginLogEntity.getUser() );
        loginLogDTO.setAddress( loginLogEntity.getAddress() );
        loginLogDTO.setClient( loginLogEntity.getClient() );
        loginLogDTO.setOs( loginLogEntity.getOs() );
        loginLogDTO.setIp( loginLogEntity.getIp() );

        return loginLogDTO;
    }

    @Override
    public LoginLogPageDTO toPageDTO(PageInfo<LoginLogDO> pageInfo) {
        if ( pageInfo == null ) {
            return null;
        }

        LoginLogPageDTO loginLogPageDTO = new LoginLogPageDTO();

        loginLogPageDTO.setRecords( loginLogDOListToLoginLogDTOList( pageInfo.getList() ) );
        loginLogPageDTO.setPage( pageInfo.getPageNum() );
        loginLogPageDTO.setTotal( pageInfo.getTotal() );

        return loginLogPageDTO;
    }

    protected LoginLogDTO loginLogDOToLoginLogDTO(LoginLogDO loginLogDO) {
        if ( loginLogDO == null ) {
            return null;
        }

        LoginLogDTO loginLogDTO = new LoginLogDTO();

        loginLogDTO.setId( loginLogDO.getId() );
        loginLogDTO.setCreateTime( loginLogDO.getCreateTime() );
        loginLogDTO.setUpdateTime( loginLogDO.getUpdateTime() );
        loginLogDTO.setCreateUser( loginLogDO.getCreateUser() );
        loginLogDTO.setUpdateUser( loginLogDO.getUpdateUser() );
        loginLogDTO.setStatus( loginLogDO.getStatus() );
        loginLogDTO.setUser( loginLogDO.getUser() );
        loginLogDTO.setAddress( loginLogDO.getAddress() );
        loginLogDTO.setClient( loginLogDO.getClient() );
        loginLogDTO.setOs( loginLogDO.getOs() );
        loginLogDTO.setIp( loginLogDO.getIp() );

        return loginLogDTO;
    }

    protected List<LoginLogDTO> loginLogDOListToLoginLogDTOList(List<LoginLogDO> list) {
        if ( list == null ) {
            return null;
        }

        List<LoginLogDTO> list1 = new ArrayList<LoginLogDTO>( list.size() );
        for ( LoginLogDO loginLogDO : list ) {
            list1.add( loginLogDOToLoginLogDTO( loginLogDO ) );
        }

        return list1;
    }
}
