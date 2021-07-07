package com.chomolungma.system.menu.assembler;

import com.chomolungma.system.menu.dto.MenuTreeDto;
import com.chomolungma.system.menu.mapstruct.MenuEntityMapStruct;
import com.chomolungma.system.menu.param.MenuParam;
import com.chomolungma.system.menu.pojo.Menu;
import com.chomolungma.system.common.tree.utils.TreeEntity;

import java.util.List;

public final class MenuAssembler {

    public static List<MenuTreeDto> convertToDto(List<Menu> orgList){
        return TreeEntity.buildTree(MenuEntityMapStruct.INSTANCE.orgToMenuTreeDto(orgList));
    }

    public static Menu convertParamToEntity(MenuParam menuParam){
        return MenuEntityMapStruct.INSTANCE.orgParamToMenu(menuParam);
    }
}
