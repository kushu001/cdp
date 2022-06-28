package com.chomolungma.system.menu.interfaces.mapstruct;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.menu.param.MenuParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MenuEntityMapStruct {
    MenuEntityMapStruct INSTANCE = Mappers.getMapper(MenuEntityMapStruct.class);

    List<MenuDTO> toMenuDto(List<MenuEntity> menuList);

    MenuEntity toMenuEntity(MenuParam menuParam);
}
