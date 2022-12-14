package com.chomolungma.system.log.interfaces.assembler;

import com.chomolungma.system.log.domain.entity.OperateLogEntity;
import com.chomolungma.system.log.infrastructure.dataobject.OperateLogDO;
import com.chomolungma.system.log.interfaces.dto.OperateLogDTO;
import com.chomolungma.system.log.interfaces.dto.OperateLogPageDTO;
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
public class OperateLogAssemblerImpl implements OperateLogAssembler {

    @Override
    public OperateLogEntity toEntity(OperateLogDTO operateLogDTO) {
        if ( operateLogDTO == null ) {
            return null;
        }

        OperateLogEntity operateLogEntity = new OperateLogEntity();

        operateLogEntity.setId( operateLogDTO.getId() );
        if ( operateLogDTO.getCreateTime() != null ) {
            operateLogEntity.setCreateTime( operateLogDTO.getCreateTime().toInstant() );
        }
        if ( operateLogDTO.getUpdateTime() != null ) {
            operateLogEntity.setUpdateTime( operateLogDTO.getUpdateTime().toInstant() );
        }
        operateLogEntity.setCreateUser( operateLogDTO.getCreateUser() );
        operateLogEntity.setUpdateUser( operateLogDTO.getUpdateUser() );
        operateLogEntity.setStatus( operateLogDTO.getStatus() );
        operateLogEntity.setUser( operateLogDTO.getUser() );
        operateLogEntity.setUrl( operateLogDTO.getUrl() );
        operateLogEntity.setRequestMethod( operateLogDTO.getRequestMethod() );
        operateLogEntity.setResourceName( operateLogDTO.getResourceName() );
        operateLogEntity.setPathPayload( operateLogDTO.getPathPayload() );
        operateLogEntity.setPayload( operateLogDTO.getPayload() );

        return operateLogEntity;
    }

    @Override
    public OperateLogDTO toDTO(OperateLogEntity operateLogEntity) {
        if ( operateLogEntity == null ) {
            return null;
        }

        OperateLogDTO operateLogDTO = new OperateLogDTO();

        operateLogDTO.setId( operateLogEntity.getId() );
        if ( operateLogEntity.getCreateTime() != null ) {
            operateLogDTO.setCreateTime( Date.from( operateLogEntity.getCreateTime() ) );
        }
        if ( operateLogEntity.getUpdateTime() != null ) {
            operateLogDTO.setUpdateTime( Date.from( operateLogEntity.getUpdateTime() ) );
        }
        operateLogDTO.setCreateUser( operateLogEntity.getCreateUser() );
        operateLogDTO.setUpdateUser( operateLogEntity.getUpdateUser() );
        operateLogDTO.setStatus( operateLogEntity.getStatus() );
        operateLogDTO.setUser( operateLogEntity.getUser() );
        operateLogDTO.setUrl( operateLogEntity.getUrl() );
        operateLogDTO.setRequestMethod( operateLogEntity.getRequestMethod() );
        operateLogDTO.setResourceName( operateLogEntity.getResourceName() );
        operateLogDTO.setPathPayload( operateLogEntity.getPathPayload() );
        operateLogDTO.setPayload( operateLogEntity.getPayload() );

        return operateLogDTO;
    }

    @Override
    public OperateLogPageDTO toPageDTO(PageInfo<OperateLogDO> pageInfo) {
        if ( pageInfo == null ) {
            return null;
        }

        OperateLogPageDTO operateLogPageDTO = new OperateLogPageDTO();

        operateLogPageDTO.setRecords( operateLogDOListToOperateLogDTOList( pageInfo.getList() ) );
        operateLogPageDTO.setPage( pageInfo.getPageNum() );
        operateLogPageDTO.setTotal( pageInfo.getTotal() );

        return operateLogPageDTO;
    }

    protected OperateLogDTO operateLogDOToOperateLogDTO(OperateLogDO operateLogDO) {
        if ( operateLogDO == null ) {
            return null;
        }

        OperateLogDTO operateLogDTO = new OperateLogDTO();

        operateLogDTO.setId( operateLogDO.getId() );
        operateLogDTO.setCreateTime( operateLogDO.getCreateTime() );
        operateLogDTO.setUpdateTime( operateLogDO.getUpdateTime() );
        operateLogDTO.setCreateUser( operateLogDO.getCreateUser() );
        operateLogDTO.setUpdateUser( operateLogDO.getUpdateUser() );
        operateLogDTO.setStatus( operateLogDO.getStatus() );
        operateLogDTO.setUser( operateLogDO.getUser() );
        operateLogDTO.setUrl( operateLogDO.getUrl() );
        operateLogDTO.setRequestMethod( operateLogDO.getRequestMethod() );
        operateLogDTO.setResourceName( operateLogDO.getResourceName() );
        operateLogDTO.setPathPayload( operateLogDO.getPathPayload() );
        operateLogDTO.setPayload( operateLogDO.getPayload() );

        return operateLogDTO;
    }

    protected List<OperateLogDTO> operateLogDOListToOperateLogDTOList(List<OperateLogDO> list) {
        if ( list == null ) {
            return null;
        }

        List<OperateLogDTO> list1 = new ArrayList<OperateLogDTO>( list.size() );
        for ( OperateLogDO operateLogDO : list ) {
            list1.add( operateLogDOToOperateLogDTO( operateLogDO ) );
        }

        return list1;
    }
}
