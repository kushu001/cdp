package com.chomolungma.system.org.infrastructure.converter;

import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import com.chomolungma.system.org.interfaces.dto.OrgDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class OrgConverterImpl implements OrgConverter {

    @Override
    public OrgEntity toEntity(OrgDO orgDO) {
        if ( orgDO == null ) {
            return null;
        }

        OrgEntity orgEntity = new OrgEntity();

        orgEntity.setId( orgDO.getId() );
        if ( orgDO.getCreateTime() != null ) {
            orgEntity.setCreateTime( orgDO.getCreateTime().toInstant() );
        }
        if ( orgDO.getUpdateTime() != null ) {
            orgEntity.setUpdateTime( orgDO.getUpdateTime().toInstant() );
        }
        orgEntity.setCreateUser( orgDO.getCreateUser() );
        orgEntity.setUpdateUser( orgDO.getUpdateUser() );
        orgEntity.setStatus( orgDO.getStatus() );
        orgEntity.setPid( orgDO.getPid() );
        orgEntity.setName( orgDO.getName() );
        orgEntity.setCode( orgDO.getCode() );
        orgEntity.setManager( orgDO.getManager() );
        orgEntity.setManagerId( orgDO.getManagerId() );
        orgEntity.setTel( orgDO.getTel() );
        orgEntity.setOrder( orgDO.getOrder() );

        return orgEntity;
    }

    @Override
    public OrgDO toDO(OrgDTO orgDTO) {
        if ( orgDTO == null ) {
            return null;
        }

        OrgDO orgDO = new OrgDO();

        orgDO.setId( orgDTO.getId() );
        orgDO.setCreateTime( orgDTO.getCreateTime() );
        orgDO.setUpdateTime( orgDTO.getUpdateTime() );
        orgDO.setCreateUser( orgDTO.getCreateUser() );
        orgDO.setUpdateUser( orgDTO.getUpdateUser() );
        orgDO.setStatus( orgDTO.getStatus() );
        orgDO.setPid( orgDTO.getPid() );
        orgDO.setName( orgDTO.getName() );
        orgDO.setCode( orgDTO.getCode() );
        orgDO.setManager( orgDTO.getManager() );
        if ( orgDTO.getManagerId() != null ) {
            orgDO.setManagerId( Long.parseLong( orgDTO.getManagerId() ) );
        }
        orgDO.setTel( orgDTO.getTel() );
        if ( orgDTO.getOrder() != null ) {
            orgDO.setOrder( Integer.parseInt( orgDTO.getOrder() ) );
        }

        return orgDO;
    }

    @Override
    public OrgDO toDO(OrgEntity org) {
        if ( org == null ) {
            return null;
        }

        OrgDO orgDO = new OrgDO();

        orgDO.setId( org.getId() );
        if ( org.getCreateTime() != null ) {
            orgDO.setCreateTime( Date.from( org.getCreateTime() ) );
        }
        if ( org.getUpdateTime() != null ) {
            orgDO.setUpdateTime( Date.from( org.getUpdateTime() ) );
        }
        orgDO.setCreateUser( org.getCreateUser() );
        orgDO.setUpdateUser( org.getUpdateUser() );
        orgDO.setStatus( org.getStatus() );
        orgDO.setPid( org.getPid() );
        orgDO.setName( org.getName() );
        orgDO.setCode( org.getCode() );
        orgDO.setManager( org.getManager() );
        orgDO.setManagerId( org.getManagerId() );
        orgDO.setTel( org.getTel() );
        orgDO.setOrder( org.getOrder() );

        return orgDO;
    }

    @Override
    public List<OrgEntity> toEntity(List<OrgDO> orgDOS) {
        if ( orgDOS == null ) {
            return null;
        }

        List<OrgEntity> list = new ArrayList<OrgEntity>( orgDOS.size() );
        for ( OrgDO orgDO : orgDOS ) {
            list.add( toEntity( orgDO ) );
        }

        return list;
    }
}
