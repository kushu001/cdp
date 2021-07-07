package com.chomolungma.system.org.mapstruct;

import com.chomolungma.system.org.dto.OrgTreeDto;
import com.chomolungma.system.org.param.OrgParam;
import com.chomolungma.system.org.pojo.Org;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrgEntityMapStruct {
    OrgEntityMapStruct INSTANCE = Mappers.getMapper(OrgEntityMapStruct.class);

    List<OrgTreeDto> orgToOrgTreeDto(List<Org> orgList);


    Org orgParamToOrg(OrgParam orgParam);
}
