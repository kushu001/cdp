package com.chomolungma.role.mapstruct;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.role.enity.RoleEntity;
import com.chomolungma.role.bo.InRoleBO;
import com.chomolungma.role.bo.OutRoleBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleEntityMapStruct {
    RoleEntityMapStruct INSTANCE = Mappers.getMapper(RoleEntityMapStruct.class);

    RoleEntity toEntity(InRoleBO inRoleBO);

    OutRoleBO toBO(IPage<RoleEntity> rolePage);
}
