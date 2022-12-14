package com.chomolungma.system.menu.infrastructure.converter;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import java.util.Date;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class MenuConverterImpl implements MenuConverter {

    @Override
    public MenuDO toDO(MenuEntity menuEntity) {
        if ( menuEntity == null ) {
            return null;
        }

        MenuDO menuDO = new MenuDO();

        menuDO.setId( menuEntity.getId() );
        if ( menuEntity.getCreateTime() != null ) {
            menuDO.setCreateTime( Date.from( menuEntity.getCreateTime() ) );
        }
        if ( menuEntity.getUpdateTime() != null ) {
            menuDO.setUpdateTime( Date.from( menuEntity.getUpdateTime() ) );
        }
        menuDO.setCreateUser( menuEntity.getCreateUser() );
        menuDO.setUpdateUser( menuEntity.getUpdateUser() );
        menuDO.setStatus( menuEntity.getStatus() );
        menuDO.setCode( menuEntity.getCode() );
        menuDO.setPCode( menuEntity.getPCode() );
        menuDO.setPid( menuEntity.getPid() );
        menuDO.setTitle( menuEntity.getTitle() );
        menuDO.setName( menuEntity.getName() );
        menuDO.setIcon( menuEntity.getIcon() );
        menuDO.setUrl( menuEntity.getUrl() );
        menuDO.setPermission( menuEntity.getPermission() );
        menuDO.setHasLeaf( menuEntity.getHasLeaf() );
        menuDO.setType( menuEntity.getType() );
        menuDO.setEnabled( menuEntity.getEnabled() );
        if ( menuEntity.getSort() != null ) {
            menuDO.setSort( Integer.parseInt( menuEntity.getSort() ) );
        }

        return menuDO;
    }
}
