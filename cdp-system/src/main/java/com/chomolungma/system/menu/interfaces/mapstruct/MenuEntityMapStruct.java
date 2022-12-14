package com.chomolungma.system.menu.interfaces.mapstruct;

import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.menu.interfaces.param.MenuParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MenuEntityMapStruct {
    MenuEntityMapStruct INSTANCE = Mappers.getMapper(MenuEntityMapStruct.class);

    List<MenuDTO> toMenuDto(List<MenuDO> menuList);
    @Mapping(target = "pid", source = "pid", defaultValue = "0l")
    MenuEntity toMenuEntity(MenuParam menuParam);
}
