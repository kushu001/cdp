package com.chomolungma.system.dict.interfaces.mapstruct;

import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.infrastructure.dataobject.DictItemDO;
import com.chomolungma.system.dict.interfaces.dto.DictItemDTO;
import com.chomolungma.system.dict.interfaces.dto.DictItemPageDTO;
import com.chomolungma.system.dict.interfaces.param.DictItemParam;
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
public class DictItemEntityMapStructImpl implements DictItemEntityMapStruct {

    @Override
    public DictItemEntity covertToEntity(DictItemParam dictItemParam) {
        if ( dictItemParam == null ) {
            return null;
        }

        DictItemEntity dictItemEntity = new DictItemEntity();

        dictItemEntity.setId( dictItemParam.getId() );
        if ( dictItemParam.getCreateTime() != null ) {
            dictItemEntity.setCreateTime( dictItemParam.getCreateTime().toInstant() );
        }
        if ( dictItemParam.getUpdateTime() != null ) {
            dictItemEntity.setUpdateTime( dictItemParam.getUpdateTime().toInstant() );
        }
        dictItemEntity.setCreateUser( dictItemParam.getCreateUser() );
        dictItemEntity.setUpdateUser( dictItemParam.getUpdateUser() );
        dictItemEntity.setStatus( dictItemParam.getStatus() );
        dictItemEntity.setDictId( dictItemParam.getDictId() );
        dictItemEntity.setCode( dictItemParam.getCode() );
        dictItemEntity.setName( dictItemParam.getName() );
        dictItemEntity.setValue( dictItemParam.getValue() );
        dictItemEntity.setSort( dictItemParam.getSort() );

        return dictItemEntity;
    }

    @Override
    public DictItemDTO toDTO(DictItemEntity dictItemEntity) {
        if ( dictItemEntity == null ) {
            return null;
        }

        DictItemDTO dictItemDTO = new DictItemDTO();

        dictItemDTO.setId( dictItemEntity.getId() );
        if ( dictItemEntity.getCreateTime() != null ) {
            dictItemDTO.setCreateTime( Date.from( dictItemEntity.getCreateTime() ) );
        }
        if ( dictItemEntity.getUpdateTime() != null ) {
            dictItemDTO.setUpdateTime( Date.from( dictItemEntity.getUpdateTime() ) );
        }
        dictItemDTO.setCreateUser( dictItemEntity.getCreateUser() );
        dictItemDTO.setUpdateUser( dictItemEntity.getUpdateUser() );
        dictItemDTO.setStatus( dictItemEntity.getStatus() );
        dictItemDTO.setCode( dictItemEntity.getCode() );
        dictItemDTO.setName( dictItemEntity.getName() );
        dictItemDTO.setValue( dictItemEntity.getValue() );
        if ( dictItemEntity.getSort() != null ) {
            dictItemDTO.setSort( String.valueOf( dictItemEntity.getSort() ) );
        }

        return dictItemDTO;
    }

    @Override
    public List<DictItemDTO> toDTO(List<DictItemDO> dictItemDOS) {
        if ( dictItemDOS == null ) {
            return null;
        }

        List<DictItemDTO> list = new ArrayList<DictItemDTO>( dictItemDOS.size() );
        for ( DictItemDO dictItemDO : dictItemDOS ) {
            list.add( dictItemDOToDictItemDTO( dictItemDO ) );
        }

        return list;
    }

    @Override
    public DictItemPageDTO toDTO(PageInfo<DictItemDO> pageInfo) {
        if ( pageInfo == null ) {
            return null;
        }

        DictItemPageDTO dictItemPageDTO = new DictItemPageDTO();

        dictItemPageDTO.setRecords( toDTO( pageInfo.getList() ) );
        dictItemPageDTO.setPage( pageInfo.getPageNum() );
        dictItemPageDTO.setTotal( pageInfo.getTotal() );

        return dictItemPageDTO;
    }

    protected DictItemDTO dictItemDOToDictItemDTO(DictItemDO dictItemDO) {
        if ( dictItemDO == null ) {
            return null;
        }

        DictItemDTO dictItemDTO = new DictItemDTO();

        dictItemDTO.setId( dictItemDO.getId() );
        dictItemDTO.setCreateTime( dictItemDO.getCreateTime() );
        dictItemDTO.setUpdateTime( dictItemDO.getUpdateTime() );
        dictItemDTO.setCreateUser( dictItemDO.getCreateUser() );
        dictItemDTO.setUpdateUser( dictItemDO.getUpdateUser() );
        dictItemDTO.setStatus( dictItemDO.getStatus() );
        dictItemDTO.setCode( dictItemDO.getCode() );
        dictItemDTO.setName( dictItemDO.getName() );
        dictItemDTO.setValue( dictItemDO.getValue() );
        if ( dictItemDO.getSort() != null ) {
            dictItemDTO.setSort( String.valueOf( dictItemDO.getSort() ) );
        }

        return dictItemDTO;
    }
}
