package com.chomolungma.system.org.interfaces.assembler;

import com.chomolungma.system.org.interfaces.dto.OrgTreeDto;
import com.chomolungma.system.org.interfaces.mapstruct.OrgEntityMapStruct;
import com.chomolungma.system.org.interfaces.param.OrgParam;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.common.tree.utils.TreeEntity;

import java.util.List;

public final class OrgAssembler {

    public static List<OrgTreeDto> convertToDto(List<OrgEntity> orgEntityList){
        return TreeEntity.buildTree(OrgEntityMapStruct.INSTANCE.orgToOrgTreeDto(orgEntityList));
    }

    public static OrgEntity convertParamToEntity(OrgParam orgParam){
        return OrgEntityMapStruct.INSTANCE.orgParamToOrg(orgParam);
    }
}
