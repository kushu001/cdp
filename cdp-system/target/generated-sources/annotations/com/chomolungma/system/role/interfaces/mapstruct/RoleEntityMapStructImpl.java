package com.chomolungma.system.role.interfaces.mapstruct;

import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.interfaces.dto.InRoleFormDTO;
import com.chomolungma.system.role.interfaces.dto.InRoleSearchDTO;
import com.chomolungma.system.role.interfaces.dto.OutRoleSearchDTO;
import com.chomolungma.system.role.interfaces.dto.RoleDTO;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class RoleEntityMapStructImpl implements RoleEntityMapStruct {

    @Override
    public RoleEntity fromSearchDTO(InRoleSearchDTO inRoleSearchDTO) {
        if ( inRoleSearchDTO == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( inRoleSearchDTO.getId() );
        roleEntity.setName( inRoleSearchDTO.getName() );
        roleEntity.setCode( inRoleSearchDTO.getCode() );
        roleEntity.setRemark( inRoleSearchDTO.getRemark() );
        roleEntity.setEnabled( inRoleSearchDTO.getEnabled() );
        roleEntity.setStatus( inRoleSearchDTO.getStatus() );
        roleEntity.setCreateTime( inRoleSearchDTO.getCreateTime() );

        return roleEntity;
    }

    @Override
    public RoleEntity fromFormDTO(InRoleFormDTO inRoleFormDTO) {
        if ( inRoleFormDTO == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( inRoleFormDTO.getId() );
        roleEntity.setName( inRoleFormDTO.getName() );
        roleEntity.setCode( inRoleFormDTO.getCode() );
        roleEntity.setRemark( inRoleFormDTO.getRemark() );
        roleEntity.setEnabled( inRoleFormDTO.getEnabled() );
        roleEntity.setStatus( inRoleFormDTO.getStatus() );

        return roleEntity;
    }

    @Override
    public OutRoleSearchDTO toDTO(PageInfo<RoleDTO> pageInfo) {
        if ( pageInfo == null ) {
            return null;
        }

        OutRoleSearchDTO outRoleSearchDTO = new OutRoleSearchDTO();

        List<RoleDTO> list = pageInfo.getList();
        if ( list != null ) {
            outRoleSearchDTO.setRecords( new ArrayList<RoleDTO>( list ) );
        }
        outRoleSearchDTO.setPage( pageInfo.getPageNum() );
        outRoleSearchDTO.setTotal( pageInfo.getTotal() );

        return outRoleSearchDTO;
    }

    @Override
    public List<RoleDTO> toDTO(List<RoleEntity> roleEntities) {
        if ( roleEntities == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( roleEntities.size() );
        for ( RoleEntity roleEntity : roleEntities ) {
            list.add( roleEntityToRoleDTO( roleEntity ) );
        }

        return list;
    }

    protected RoleDTO roleEntityToRoleDTO(RoleEntity roleEntity) {
        if ( roleEntity == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( roleEntity.getId() );
        roleDTO.setCreateTime( roleEntity.getCreateTime() );
        roleDTO.setStatus( roleEntity.getStatus() );
        roleDTO.setName( roleEntity.getName() );
        roleDTO.setCode( roleEntity.getCode() );
        roleDTO.setEnabled( roleEntity.getEnabled() );
        roleDTO.setRemark( roleEntity.getRemark() );

        return roleDTO;
    }
}
