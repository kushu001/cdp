package com.chomolungma.system.role.interfaces.assembler;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.interfaces.dto.InRoleFormDTO;
import com.chomolungma.system.role.interfaces.dto.InRoleSearchDTO;
import com.chomolungma.system.role.interfaces.dto.OutRoleFormDTO;
import com.chomolungma.system.role.interfaces.dto.OutRoleSearchDTO;
import com.chomolungma.system.role.interfaces.mapstruct.RoleEntityMapStruct;
import com.github.pagehelper.PageInfo;

public class RoleAssembler {
    public static RoleEntity toEntity(InRoleSearchDTO inRoleSearchDTO){
        return RoleEntityMapStruct.INSTANCE.fromSearchDTO(inRoleSearchDTO);
    }

    public static RoleEntity toEntity(InRoleFormDTO inRoleFormDTO){
        return RoleEntityMapStruct.INSTANCE.fromFormDTO(inRoleFormDTO);
    }

    public static OutRoleSearchDTO toOutRoleSearchDTO(IPage<RoleEntity> roleEntity){
        return RoleEntityMapStruct.INSTANCE.toOutRoleSearchDTO(roleEntity);
    }

    public static OutRoleFormDTO toOutRoleFormDTO(RoleEntity roleEntity){
        return RoleEntityMapStruct.INSTANCE.toOutRoleFormDTO(roleEntity);
    }

    public static OutRoleSearchDTO toDTO(PageInfo<RoleEntity> pageInfo){
        return RoleEntityMapStruct.INSTANCE.toDTO(pageInfo);
    }

}
