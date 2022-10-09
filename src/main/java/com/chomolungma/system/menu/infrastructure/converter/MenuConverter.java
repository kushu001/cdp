package com.chomolungma.system.menu.infrastructure.converter;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuConverter {
    MenuConverter INSTANCE = Mappers.getMapper(MenuConverter.class);
    MenuDO toDO(MenuEntity menuEntity);


}
