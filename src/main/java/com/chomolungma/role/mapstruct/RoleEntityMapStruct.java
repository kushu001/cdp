package com.chomolungma.role.mapstruct;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.role.bo.InRoleFormBO;
import com.chomolungma.role.bo.InRoleSearchBO;
import com.chomolungma.role.bo.OutRoleFormBO;
import com.chomolungma.role.enity.RoleEntity;
import com.chomolungma.role.bo.OutRoleSearchBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleEntityMapStruct {
    RoleEntityMapStruct INSTANCE = Mappers.getMapper(RoleEntityMapStruct.class);

    RoleEntity fromSearchBO(InRoleSearchBO inRoleSearchBO);

    RoleEntity fromFormBO(InRoleFormBO inRoleFormBO);

    OutRoleSearchBO toOutRoleSearchBO(IPage<RoleEntity> rolePage);

    OutRoleFormBO toOutRoleFormBO(RoleEntity role);
}
