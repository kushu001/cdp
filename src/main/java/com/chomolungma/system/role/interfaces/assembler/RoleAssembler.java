package com.chomolungma.system.role.interfaces.assembler;

import com.chomolungma.system.role.interfaces.dto.RoleDTO;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.interfaces.dto.InRoleFormDTO;
import com.chomolungma.system.role.interfaces.dto.InRoleSearchDTO;
import com.chomolungma.system.role.interfaces.dto.OutRoleSearchDTO;
import com.chomolungma.system.role.interfaces.mapstruct.RoleEntityMapStruct;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class RoleAssembler {
    public static RoleEntity toEntity(InRoleSearchDTO inRoleSearchDTO){
        return RoleEntityMapStruct.INSTANCE.fromSearchDTO(inRoleSearchDTO);
    }

    public static RoleEntity toEntity(InRoleFormDTO inRoleFormDTO){
        return RoleEntityMapStruct.INSTANCE.fromFormDTO(inRoleFormDTO);
    }

    public static OutRoleSearchDTO toDTO(PageInfo<RoleDTO> pageInfo){
        return RoleEntityMapStruct.INSTANCE.toDTO(pageInfo);
    }

    public static List<RoleDTO> toDTO(List<RoleEntity> roleEntities){
        return RoleEntityMapStruct.INSTANCE.toDTO(roleEntities);
    }

}
