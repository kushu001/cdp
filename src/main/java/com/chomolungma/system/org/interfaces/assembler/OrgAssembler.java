package com.chomolungma.system.org.interfaces.assembler;

import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import com.chomolungma.system.org.interfaces.dto.OrgDTO;
import com.chomolungma.system.org.interfaces.mapstruct.OrgEntityMapStruct;
import com.chomolungma.system.org.interfaces.param.OrgParam;
import com.chomolungma.system.org.interfaces.param.OrgSearchParam;

import java.util.List;

public final class OrgAssembler {

    public static List<OrgDTO> toDTO(List<OrgEntity> orgList){
        return OrgEntityMapStruct.INSTANCE.toDTO(orgList);
    }


}
