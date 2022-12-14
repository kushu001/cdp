package com.chomolungma.system.dict.interfaces.mapstruct;

import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.infrastructure.dataobject.DictDO;
import com.chomolungma.system.dict.interfaces.dto.DictDTO;
import com.chomolungma.system.dict.interfaces.dto.DictPageDTO;
import com.chomolungma.system.dict.interfaces.param.DictParam;
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
public class DictEntityMapStructImpl implements DictEntityMapStruct {

    @Override
    public DictEntity covertToEntity(DictParam dictParam) {
        if ( dictParam == null ) {
            return null;
        }

        DictEntity dictEntity = new DictEntity();

        dictEntity.setId( dictParam.getId() );
        if ( dictParam.getCreateTime() != null ) {
            dictEntity.setCreateTime( dictParam.getCreateTime().toInstant() );
        }
        if ( dictParam.getUpdateTime() != null ) {
            dictEntity.setUpdateTime( dictParam.getUpdateTime().toInstant() );
        }
        dictEntity.setCreateUser( dictParam.getCreateUser() );
        dictEntity.setUpdateUser( dictParam.getUpdateUser() );
        dictEntity.setStatus( dictParam.getStatus() );
        dictEntity.setCode( dictParam.getCode() );
        dictEntity.setName( dictParam.getName() );
        if ( dictParam.getSort() != null ) {
            dictEntity.setSort( String.valueOf( dictParam.getSort() ) );
        }

        return dictEntity;
    }

    @Override
    public DictDTO toDTO(DictEntity dictEntity) {
        if ( dictEntity == null ) {
            return null;
        }

        DictDTO dictDTO = new DictDTO();

        dictDTO.setId( dictEntity.getId() );
        if ( dictEntity.getCreateTime() != null ) {
            dictDTO.setCreateTime( Date.from( dictEntity.getCreateTime() ) );
        }
        if ( dictEntity.getUpdateTime() != null ) {
            dictDTO.setUpdateTime( Date.from( dictEntity.getUpdateTime() ) );
        }
        dictDTO.setCreateUser( dictEntity.getCreateUser() );
        dictDTO.setUpdateUser( dictEntity.getUpdateUser() );
        dictDTO.setStatus( dictEntity.getStatus() );
        dictDTO.setCode( dictEntity.getCode() );
        dictDTO.setName( dictEntity.getName() );
        dictDTO.setSort( dictEntity.getSort() );

        return dictDTO;
    }

    @Override
    public DictPageDTO toDTO(PageInfo<DictDO> pageInfo) {
        if ( pageInfo == null ) {
            return null;
        }

        DictPageDTO dictPageDTO = new DictPageDTO();

        dictPageDTO.setRecords( dictDOListToDictDTOList( pageInfo.getList() ) );
        dictPageDTO.setPage( pageInfo.getPageNum() );
        dictPageDTO.setTotal( pageInfo.getTotal() );

        return dictPageDTO;
    }

    protected DictDTO dictDOToDictDTO(DictDO dictDO) {
        if ( dictDO == null ) {
            return null;
        }

        DictDTO dictDTO = new DictDTO();

        dictDTO.setId( dictDO.getId() );
        dictDTO.setCreateTime( dictDO.getCreateTime() );
        dictDTO.setUpdateTime( dictDO.getUpdateTime() );
        dictDTO.setCreateUser( dictDO.getCreateUser() );
        dictDTO.setUpdateUser( dictDO.getUpdateUser() );
        dictDTO.setStatus( dictDO.getStatus() );
        dictDTO.setCode( dictDO.getCode() );
        dictDTO.setName( dictDO.getName() );
        if ( dictDO.getSort() != null ) {
            dictDTO.setSort( String.valueOf( dictDO.getSort() ) );
        }

        return dictDTO;
    }

    protected List<DictDTO> dictDOListToDictDTOList(List<DictDO> list) {
        if ( list == null ) {
            return null;
        }

        List<DictDTO> list1 = new ArrayList<DictDTO>( list.size() );
        for ( DictDO dictDO : list ) {
            list1.add( dictDOToDictDTO( dictDO ) );
        }

        return list1;
    }
}
