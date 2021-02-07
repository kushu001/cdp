package com.chomolungma.org.assembler;

import com.chomolungma.common.tree.Utils.TreeEntity;
import com.chomolungma.org.dto.OrgTreeDto;
import com.chomolungma.org.mapstruct.OrgEntityMapStruct;
import com.chomolungma.org.param.OrgParam;
import com.chomolungma.org.pojo.Org;

import java.util.List;

public final class OrgAssembler {

    public static List<OrgTreeDto> convertToDto(List<Org> orgList){
        return TreeEntity.buildTree(OrgEntityMapStruct.INSTANCE.orgToOrgTreeDto(orgList));
    }

    public static Org convertParamToEntity(OrgParam orgParam){
        return OrgEntityMapStruct.INSTANCE.orgParamToOrg(orgParam);
    }
}
