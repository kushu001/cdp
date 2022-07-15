package com.chomolungma.system.menu.interfaces.assembler;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.menu.interfaces.mapstruct.MenuEntityMapStruct;
import com.chomolungma.system.menu.param.MenuParam;

import java.util.List;

public final class MenuAssembler {

    public static List<MenuDTO> convertToDto(List<MenuEntity> menuList){
        return MenuEntityMapStruct.INSTANCE.toMenuDto(menuList);
    }

    public static MenuEntity convertParamToEntity(MenuParam menuParam){
        return MenuEntityMapStruct.INSTANCE.toMenuEntity(menuParam);
    }
}