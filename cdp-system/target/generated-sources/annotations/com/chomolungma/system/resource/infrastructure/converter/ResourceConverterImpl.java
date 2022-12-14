package com.chomolungma.system.resource.infrastructure.converter;

import com.chomolungma.system.resource.domain.entity.ResourceEntity;
import com.chomolungma.system.resource.infrastructure.dataobject.ResourceDO;
import com.chomolungma.system.resource.interfaces.dto.ResourceDTO;
import com.chomolungma.system.resource.interfaces.dto.ResourcePageDTO;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class ResourceConverterImpl implements ResourceConverter {

    @Override
    public ResourceDO toDO(ResourceEntity resourceEntity) {
        if ( resourceEntity == null ) {
            return null;
        }

        ResourceDO resourceDO = new ResourceDO();

        resourceDO.setId( resourceEntity.getId() );
        if ( resourceEntity.getCreateTime() != null ) {
            resourceDO.setCreateTime( Date.from( resourceEntity.getCreateTime() ) );
        }
        if ( resourceEntity.getUpdateTime() != null ) {
            resourceDO.setUpdateTime( Date.from( resourceEntity.getUpdateTime() ) );
        }
        resourceDO.setCreateUser( resourceEntity.getCreateUser() );
        resourceDO.setUpdateUser( resourceEntity.getUpdateUser() );
        resourceDO.setStatus( resourceEntity.getStatus() );
        resourceDO.setName( resourceEntity.getName() );
        resourceDO.setSign( resourceEntity.getSign() );
        resourceDO.setUrl( resourceEntity.getUrl() );

        return resourceDO;
    }

    @Override
    public ResourceEntity toEntity(ResourceDO resourceDO) {
        if ( resourceDO == null ) {
            return null;
        }

        ResourceEntity resourceEntity = new ResourceEntity();

        resourceEntity.setId( resourceDO.getId() );
        if ( resourceDO.getCreateTime() != null ) {
            resourceEntity.setCreateTime( resourceDO.getCreateTime().toInstant() );
        }
        if ( resourceDO.getUpdateTime() != null ) {
            resourceEntity.setUpdateTime( resourceDO.getUpdateTime().toInstant() );
        }
        resourceEntity.setCreateUser( resourceDO.getCreateUser() );
        resourceEntity.setUpdateUser( resourceDO.getUpdateUser() );
        resourceEntity.setStatus( resourceDO.getStatus() );
        resourceEntity.setName( resourceDO.getName() );
        resourceEntity.setSign( resourceDO.getSign() );
        resourceEntity.setUrl( resourceDO.getUrl() );

        return resourceEntity;
    }

    @Override
    public ResourcePageDTO toDTO(PageInfo<ResourceDO> pageInfo) {
        if ( pageInfo == null ) {
            return null;
        }

        ResourcePageDTO resourcePageDTO = new ResourcePageDTO();

        resourcePageDTO.setRecords( resourceDOListToResourceDTOList( pageInfo.getList() ) );
        resourcePageDTO.setPage( pageInfo.getPageNum() );
        resourcePageDTO.setTotal( pageInfo.getTotal() );

        return resourcePageDTO;
    }

    protected ResourceDTO resourceDOToResourceDTO(ResourceDO resourceDO) {
        if ( resourceDO == null ) {
            return null;
        }

        ResourceDTO resourceDTO = new ResourceDTO();

        resourceDTO.setId( resourceDO.getId() );
        resourceDTO.setCreateTime( resourceDO.getCreateTime() );
        resourceDTO.setUpdateTime( resourceDO.getUpdateTime() );
        resourceDTO.setCreateUser( resourceDO.getCreateUser() );
        resourceDTO.setUpdateUser( resourceDO.getUpdateUser() );
        resourceDTO.setStatus( resourceDO.getStatus() );
        resourceDTO.setName( resourceDO.getName() );
        resourceDTO.setSign( resourceDO.getSign() );
        resourceDTO.setUrl( resourceDO.getUrl() );

        return resourceDTO;
    }

    protected List<ResourceDTO> resourceDOListToResourceDTOList(List<ResourceDO> list) {
        if ( list == null ) {
            return null;
        }

        List<ResourceDTO> list1 = new ArrayList<ResourceDTO>( list.size() );
        for ( ResourceDO resourceDO : list ) {
            list1.add( resourceDOToResourceDTO( resourceDO ) );
        }

        return list1;
    }
}
