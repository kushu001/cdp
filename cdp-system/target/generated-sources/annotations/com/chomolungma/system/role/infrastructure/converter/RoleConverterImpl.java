package com.chomolungma.system.role.infrastructure.converter;

import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.infrastructure.dataobject.RoleDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class RoleConverterImpl implements RoleConverter {

    @Override
    public RoleEntity toEntity(RoleDO roleDO) {
        if ( roleDO == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( roleDO.getId() );
        roleEntity.setName( roleDO.getName() );
        roleEntity.setCode( roleDO.getCode() );
        roleEntity.setRemark( roleDO.getRemark() );
        roleEntity.setEnabled( roleDO.getEnabled() );
        roleEntity.setStatus( roleDO.getStatus() );
        roleEntity.setCreateTime( roleDO.getCreateTime() );

        return roleEntity;
    }

    @Override
    public RoleDO toDO(RoleEntity role) {
        if ( role == null ) {
            return null;
        }

        RoleDO roleDO = new RoleDO();

        roleDO.setId( role.getId() );
        roleDO.setCreateTime( role.getCreateTime() );
        roleDO.setName( role.getName() );
        roleDO.setCode( role.getCode() );
        roleDO.setRemark( role.getRemark() );
        roleDO.setEnabled( role.getEnabled() );
        roleDO.setStatus( role.getStatus() );

        return roleDO;
    }

    @Override
    public List<RoleEntity> toEntity(List<RoleDO> roleDOS) {
        if ( roleDOS == null ) {
            return null;
        }

        List<RoleEntity> list = new ArrayList<RoleEntity>( roleDOS.size() );
        for ( RoleDO roleDO : roleDOS ) {
            list.add( toEntity( roleDO ) );
        }

        return list;
    }
}
