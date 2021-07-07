package com.chomolungma.system.menu.mapstruct;

import com.chomolungma.system.menu.dto.MenuTreeDto;
import com.chomolungma.system.menu.param.MenuParam;
import com.chomolungma.system.menu.pojo.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MenuEntityMapStruct {
    MenuEntityMapStruct INSTANCE = Mappers.getMapper(MenuEntityMapStruct.class);

    List<MenuTreeDto> orgToMenuTreeDto(List<Menu> orgList);


    Menu orgParamToMenu(MenuParam menuParam);
}
