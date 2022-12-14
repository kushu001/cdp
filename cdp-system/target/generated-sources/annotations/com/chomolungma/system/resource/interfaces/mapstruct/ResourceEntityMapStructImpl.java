package com.chomolungma.system.resource.interfaces.mapstruct;

import com.chomolungma.system.resource.domain.entity.ResourceEntity;
import com.chomolungma.system.resource.interfaces.dto.ResourceDTO;
import com.chomolungma.system.resource.interfaces.param.ResourceParam;
import java.util.Date;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class ResourceEntityMapStructImpl implements ResourceEntityMapStruct {

    @Override
    public ResourceEntity toEntity(ResourceParam resourceParam) {
        if ( resourceParam == null ) {
            return null;
        }

        ResourceEntity resourceEntity = new ResourceEntity();

        resourceEntity.setId( resourceParam.getId() );
        resourceEntity.setName( resourceParam.getName() );
        resourceEntity.setSign( resourceParam.getSign() );
        resourceEntity.setUrl( resourceParam.getUrl() );

        return resourceEntity;
    }

    @Override
    public ResourceDTO toDTO(ResourceEntity resourceEntity) {
        if ( resourceEntity == null ) {
            return null;
        }

        ResourceDTO resourceDTO = new ResourceDTO();

        resourceDTO.setId( resourceEntity.getId() );
        if ( resourceEntity.getCreateTime() != null ) {
            resourceDTO.setCreateTime( Date.from( resourceEntity.getCreateTime() ) );
        }
        if ( resourceEntity.getUpdateTime() != null ) {
            resourceDTO.setUpdateTime( Date.from( resourceEntity.getUpdateTime() ) );
        }
        resourceDTO.setCreateUser( resourceEntity.getCreateUser() );
        resourceDTO.setUpdateUser( resourceEntity.getUpdateUser() );
        resourceDTO.setStatus( resourceEntity.getStatus() );
        resourceDTO.setName( resourceEntity.getName() );
        resourceDTO.setSign( resourceEntity.getSign() );
        resourceDTO.setUrl( resourceEntity.getUrl() );

        return resourceDTO;
    }
}
