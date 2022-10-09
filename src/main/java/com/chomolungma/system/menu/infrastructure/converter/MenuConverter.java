package com.chomolungma.system.menu.domain.repository.converter;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.domain.repository.dataobject.MenuDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MenuConverter {
    MenuConverter INSTANCE = Mappers.getMapper(MenuConverter.class);

    List<MenuEntity> toEntity(List<MenuDO> menuDOS);
}
