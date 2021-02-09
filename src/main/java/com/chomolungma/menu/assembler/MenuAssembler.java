package com.chomolungma.menu.assembler;

import com.chomolungma.common.tree.utils.TreeEntity;
import com.chomolungma.menu.dto.MenuTreeDto;
import com.chomolungma.menu.mapstruct.MenuEntityMapStruct;
import com.chomolungma.menu.param.MenuParam;
import com.chomolungma.menu.pojo.Menu;

import java.util.List;

public final class MenuAssembler {

    public static List<MenuTreeDto> convertToDto(List<Menu> orgList){
        return TreeEntity.buildTree(MenuEntityMapStruct.INSTANCE.orgToMenuTreeDto(orgList));
    }

    public static Menu convertParamToEntity(MenuParam menuParam){
        return MenuEntityMapStruct.INSTANCE.orgParamToMenu(menuParam);
    }
}
