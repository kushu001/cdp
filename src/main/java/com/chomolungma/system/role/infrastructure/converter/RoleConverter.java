package com.chomolungma.system.role.infrastructure.converter;

import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.infrastructure.dataobject.RoleDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleConverter {
    RoleConverter INSTANCE = Mappers.getMapper(RoleConverter.class);

    RoleEntity toEntity(RoleDO roleDO);

    RoleDO toDO(RoleEntity role);

    List<RoleEntity> toEntity(List<RoleDO> roleDOS);
}
