package com.chomolungma.system.org.interfaces.mapstruct;

import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import com.chomolungma.system.org.interfaces.dto.OrgDTO;
import com.chomolungma.system.org.interfaces.param.OrgParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class OrgEntityMapStructImpl implements OrgEntityMapStruct {

    @Override
    public List<OrgDTO> toDTO(List<OrgEntity> orgList) {
        if ( orgList == null ) {
            return null;
        }

        List<OrgDTO> list = new ArrayList<OrgDTO>( orgList.size() );
        for ( OrgEntity orgEntity : orgList ) {
            list.add( toDTO( orgEntity ) );
        }

        return list;
    }

    @Override
    public OrgDTO toDTO(OrgEntity orgEntity) {
        if ( orgEntity == null ) {
            return null;
        }

        OrgDTO orgDTO = new OrgDTO();

        orgDTO.setId( orgEntity.getId() );
        if ( orgEntity.getCreateTime() != null ) {
            orgDTO.setCreateTime( Date.from( orgEntity.getCreateTime() ) );
        }
        if ( orgEntity.getUpdateTime() != null ) {
            orgDTO.setUpdateTime( Date.from( orgEntity.getUpdateTime() ) );
        }
        orgDTO.setCreateUser( orgEntity.getCreateUser() );
        orgDTO.setUpdateUser( orgEntity.getUpdateUser() );
        orgDTO.setStatus( orgEntity.getStatus() );
        orgDTO.setPid( orgEntity.getPid() );
        orgDTO.setName( orgEntity.getName() );
        orgDTO.setCode( orgEntity.getCode() );
        orgDTO.setManager( orgEntity.getManager() );
        if ( orgEntity.getManagerId() != null ) {
            orgDTO.setManagerId( String.valueOf( orgEntity.getManagerId() ) );
        }
        orgDTO.setTel( orgEntity.getTel() );
        if ( orgEntity.getOrder() != null ) {
            orgDTO.setOrder( String.valueOf( orgEntity.getOrder() ) );
        }

        return orgDTO;
    }

    @Override
    public OrgEntity toEntity(OrgParam orgParam) {
        if ( orgParam == null ) {
            return null;
        }

        OrgEntity orgEntity = new OrgEntity();

        orgEntity.setId( orgParam.getId() );
        if ( orgParam.getStatus() != null ) {
            orgEntity.setStatus( Integer.parseInt( orgParam.getStatus() ) );
        }
        orgEntity.setPid( orgParam.getPid() );
        orgEntity.setName( orgParam.getName() );
        orgEntity.setCode( orgParam.getCode() );
        orgEntity.setManager( orgParam.getManager() );
        orgEntity.setManagerId( orgParam.getManagerId() );
        orgEntity.setTel( orgParam.getTel() );
        orgEntity.setOrder( orgParam.getOrder() );

        return orgEntity;
    }

    @Override
    public OrgDO toDO(OrgParam orgParam) {
        if ( orgParam == null ) {
            return null;
        }

        OrgDO orgDO = new OrgDO();

        orgDO.setId( orgParam.getId() );
        if ( orgParam.getStatus() != null ) {
            orgDO.setStatus( Integer.parseInt( orgParam.getStatus() ) );
        }
        orgDO.setPid( orgParam.getPid() );
        orgDO.setName( orgParam.getName() );
        orgDO.setCode( orgParam.getCode() );
        orgDO.setManager( orgParam.getManager() );
        orgDO.setManagerId( orgParam.getManagerId() );
        orgDO.setTel( orgParam.getTel() );
        orgDO.setOrder( orgParam.getOrder() );

        return orgDO;
    }
}
