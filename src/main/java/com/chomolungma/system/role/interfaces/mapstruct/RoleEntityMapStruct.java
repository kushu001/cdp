package com.chomolungma.system.role.interfaces.mapstruct;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.role.interfaces.dto.*;
import com.chomolungma.system.role.domain.enity.RoleEntity;
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

    OutRoleSearchDTO toOutRoleSearchDTO(IPage<RoleEntity> rolePage);

    OutRoleFormDTO toOutRoleFormDTO(RoleEntity role);

    List<Role> toList(List<RoleEntity> roles);

    @Mappings({
            @Mapping(target = "records", source = "list"),
            @Mapping(target = "page", source = "pageNum")
    })
    OutRoleSearchDTO toDTO(PageInfo<RoleEntity> pageInfo);


}
