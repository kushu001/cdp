package com.chomolungma.system.menu.interfaces.mapstruct;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.menu.interfaces.param.MenuParam;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class MenuEntityMapStructImpl implements MenuEntityMapStruct {

    @Override
    public List<MenuDTO> toMenuDto(List<MenuDO> menuList) {
        if ( menuList == null ) {
            return null;
        }

        List<MenuDTO> list = new ArrayList<MenuDTO>( menuList.size() );
        for ( MenuDO menuDO : menuList ) {
            list.add( menuDOToMenuDTO( menuDO ) );
        }

        return list;
    }

    @Override
    public MenuEntity toMenuEntity(MenuParam menuParam) {
        if ( menuParam == null ) {
            return null;
        }

        MenuEntity menuEntity = new MenuEntity();

        if ( menuParam.getPid() != null ) {
            menuEntity.setPid( menuParam.getPid() );
        }
        else {
            menuEntity.setPid( (long) 0l );
        }
        menuEntity.setId( menuParam.getId() );
        if ( menuParam.getStatus() != null ) {
            menuEntity.setStatus( Integer.parseInt( menuParam.getStatus() ) );
        }
        menuEntity.setTitle( menuParam.getTitle() );
        menuEntity.setName( menuParam.getName() );
        menuEntity.setUrl( menuParam.getUrl() );
        menuEntity.setIcon( menuParam.getIcon() );
        menuEntity.setSort( menuParam.getSort() );
        menuEntity.setPermission( menuParam.getPermission() );
        menuEntity.setType( menuParam.getType() );
        menuEntity.setEnabled( menuParam.getEnabled() );

        return menuEntity;
    }

    protected MenuDTO menuDOToMenuDTO(MenuDO menuDO) {
        if ( menuDO == null ) {
            return null;
        }

        MenuDTO menuDTO = new MenuDTO();

        menuDTO.setId( menuDO.getId() );
        menuDTO.setCreateTime( menuDO.getCreateTime() );
        menuDTO.setUpdateTime( menuDO.getUpdateTime() );
        menuDTO.setCreateUser( menuDO.getCreateUser() );
        menuDTO.setUpdateUser( menuDO.getUpdateUser() );
        menuDTO.setStatus( menuDO.getStatus() );
        menuDTO.setCode( menuDO.getCode() );
        menuDTO.setPCode( menuDO.getPCode() );
        menuDTO.setPid( menuDO.getPid() );
        menuDTO.setTitle( menuDO.getTitle() );
        menuDTO.setName( menuDO.getName() );
        menuDTO.setUrl( menuDO.getUrl() );
        menuDTO.setIcon( menuDO.getIcon() );
        menuDTO.setPermission( menuDO.getPermission() );
        menuDTO.setHasLeaf( menuDO.getHasLeaf() );
        if ( menuDO.getSort() != null ) {
            menuDTO.setSort( String.valueOf( menuDO.getSort() ) );
        }
        menuDTO.setType( menuDO.getType() );
        menuDTO.setEnabled( menuDO.getEnabled() );

        return menuDTO;
    }
}
