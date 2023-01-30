package com.chomolungma.system.menu.interfaces.assembler;

import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import com.chomolungma.system.menu.interfaces.mapstruct.MenuEntityMapStruct;
import com.chomolungma.system.menu.interfaces.param.MenuParam;
import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;

import java.util.List;

public final class MenuAssembler {

    public static List<MenuDTO> convertToDto(List<MenuDO> menuList){
        return MenuEntityMapStruct.INSTANCE.toMenuDto(menuList);
    }

    public static MenuEntity convertParamToEntity(MenuParam menuParam){
        MenuEntity menuEntity = MenuEntityMapStruct.INSTANCE.toMenuEntity(menuParam);
        if (menuParam.getType().equals("0")){
            menuEntity.setName(menuParam.getUrl().substring(1).replaceAll("/","-"));
        }
        return menuEntity;
    }
}
