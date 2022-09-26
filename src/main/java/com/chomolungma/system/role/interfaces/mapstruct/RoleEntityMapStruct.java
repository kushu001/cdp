package com.chomolungma.system.role.interfaces.mapstruct;

import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.interfaces.dto.InRoleFormDTO;
import com.chomolungma.system.role.interfaces.dto.InRoleSearchDTO;
import com.chomolungma.system.role.interfaces.dto.OutRoleSearchDTO;
import com.chomolungma.system.role.interfaces.dto.Role;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleEntityMapStruct {
    RoleEntityMapStruct INSTANCE = Mappers.getMapper(RoleEntityMapStruct.class);

    RoleEntity fromSearchDTO(InRoleSearchDTO inRoleSearchDTO);

    RoleEntity fromFormDTO(InRoleFormDTO inRoleFormDTO);

    List<Role> toList(List<RoleEntity> roles);

    @Mappings({
            @Mapping(target = "records", source = "list"),
            @Mapping(target = "page", source = "pageNum")
    })
    OutRoleSearchDTO toDTO(PageInfo<RoleEntity> pageInfo);


}
