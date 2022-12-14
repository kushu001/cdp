package com.chomolungma.system.dict.infrastructure.converter;

import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.infrastructure.dataobject.DictDO;
import java.util.Date;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class DictConverterImpl implements DictConverter {

    @Override
    public DictEntity toEntity(DictDO dictDO) {
        if ( dictDO == null ) {
            return null;
        }

        DictEntity dictEntity = new DictEntity();

        dictEntity.setId( dictDO.getId() );
        if ( dictDO.getCreateTime() != null ) {
            dictEntity.setCreateTime( dictDO.getCreateTime().toInstant() );
        }
        if ( dictDO.getUpdateTime() != null ) {
            dictEntity.setUpdateTime( dictDO.getUpdateTime().toInstant() );
        }
        dictEntity.setCreateUser( dictDO.getCreateUser() );
        dictEntity.setUpdateUser( dictDO.getUpdateUser() );
        dictEntity.setStatus( dictDO.getStatus() );
        dictEntity.setCode( dictDO.getCode() );
        dictEntity.setName( dictDO.getName() );
        if ( dictDO.getSort() != null ) {
            dictEntity.setSort( String.valueOf( dictDO.getSort() ) );
        }

        return dictEntity;
    }

    @Override
    public DictDO toDO(DictEntity dictEntity) {
        if ( dictEntity == null ) {
            return null;
        }

        DictDO dictDO = new DictDO();

        dictDO.setId( dictEntity.getId() );
        if ( dictEntity.getCreateTime() != null ) {
            dictDO.setCreateTime( Date.from( dictEntity.getCreateTime() ) );
        }
        if ( dictEntity.getUpdateTime() != null ) {
            dictDO.setUpdateTime( Date.from( dictEntity.getUpdateTime() ) );
        }
        dictDO.setCreateUser( dictEntity.getCreateUser() );
        dictDO.setUpdateUser( dictEntity.getUpdateUser() );
        dictDO.setStatus( dictEntity.getStatus() );
        dictDO.setName( dictEntity.getName() );
        dictDO.setCode( dictEntity.getCode() );
        if ( dictEntity.getSort() != null ) {
            dictDO.setSort( Integer.parseInt( dictEntity.getSort() ) );
        }

        return dictDO;
    }
}
