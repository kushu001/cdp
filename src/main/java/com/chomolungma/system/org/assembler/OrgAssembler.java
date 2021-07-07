package com.chomolungma.system.org.assembler;

import com.chomolungma.system.org.dto.OrgTreeDto;
import com.chomolungma.system.org.mapstruct.OrgEntityMapStruct;
import com.chomolungma.system.org.param.OrgParam;
import com.chomolungma.system.org.pojo.Org;
import com.chomolungma.system.common.tree.utils.TreeEntity;

import java.util.List;

public final class OrgAssembler {

    public static List<OrgTreeDto> convertToDto(List<Org> orgList){
        return TreeEntity.buildTree(OrgEntityMapStruct.INSTANCE.orgToOrgTreeDto(orgList));
    }

    public static Org convertParamToEntity(OrgParam orgParam){
        return OrgEntityMapStruct.INSTANCE.orgParamToOrg(orgParam);
    }
}
