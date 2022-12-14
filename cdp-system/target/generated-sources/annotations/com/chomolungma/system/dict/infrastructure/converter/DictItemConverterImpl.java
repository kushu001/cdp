package com.chomolungma.system.dict.infrastructure.converter;

import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.infrastructure.dataobject.DictItemDO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class DictItemConverterImpl implements DictItemConverter {

    @Override
    public DictItemEntity toEntity(DictItemDO dictItemDO) {
        if ( dictItemDO == null ) {
            return null;
        }

        DictItemEntity dictItemEntity = new DictItemEntity();

        dictItemEntity.setId( dictItemDO.getId() );
        if ( dictItemDO.getCreateTime() != null ) {
            dictItemEntity.setCreateTime( dictItemDO.getCreateTime().toInstant() );
        }
        if ( dictItemDO.getUpdateTime() != null ) {
            dictItemEntity.setUpdateTime( dictItemDO.getUpdateTime().toInstant() );
        }
        dictItemEntity.setCreateUser( dictItemDO.getCreateUser() );
        dictItemEntity.setUpdateUser( dictItemDO.getUpdateUser() );
        dictItemEntity.setStatus( dictItemDO.getStatus() );
        dictItemEntity.setDictId( dictItemDO.getDictId() );
        dictItemEntity.setCode( dictItemDO.getCode() );
        dictItemEntity.setName( dictItemDO.getName() );
        dictItemEntity.setValue( dictItemDO.getValue() );
        dictItemEntity.setSort( dictItemDO.getSort() );

        return dictItemEntity;
    }

    @Override
    public List<DictItemEntity> toEntity(List<DictItemDO> dictItemDOS) {
        if ( dictItemDOS == null ) {
            return null;
        }

        List<DictItemEntity> list = new ArrayList<DictItemEntity>( dictItemDOS.size() );
        for ( DictItemDO dictItemDO : dictItemDOS ) {
            list.add( toEntity( dictItemDO ) );
        }

        return list;
    }

    @Override
    public DictItemDO toDO(DictItemEntity dictItemEntity) {
        if ( dictItemEntity == null ) {
            return null;
        }

        DictItemDO dictItemDO = new DictItemDO();

        dictItemDO.setId( dictItemEntity.getId() );
        if ( dictItemEntity.getCreateTime() != null ) {
            dictItemDO.setCreateTime( Date.from( dictItemEntity.getCreateTime() ) );
        }
        if ( dictItemEntity.getUpdateTime() != null ) {
            dictItemDO.setUpdateTime( Date.from( dictItemEntity.getUpdateTime() ) );
        }
        dictItemDO.setCreateUser( dictItemEntity.getCreateUser() );
        dictItemDO.setUpdateUser( dictItemEntity.getUpdateUser() );
        dictItemDO.setStatus( dictItemEntity.getStatus() );
        dictItemDO.setDictId( dictItemEntity.getDictId() );
        dictItemDO.setName( dictItemEntity.getName() );
        dictItemDO.setValue( dictItemEntity.getValue() );
        dictItemDO.setCode( dictItemEntity.getCode() );
        dictItemDO.setSort( dictItemEntity.getSort() );

        return dictItemDO;
    }
}
