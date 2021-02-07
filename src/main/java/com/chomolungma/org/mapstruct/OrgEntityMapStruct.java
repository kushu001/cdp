package com.chomolungma.org.mapstruct;

import com.chomolungma.org.dto.OrgTreeDto;
import com.chomolungma.org.param.OrgParam;
import com.chomolungma.org.pojo.Org;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrgEntityMapStruct {
    OrgEntityMapStruct INSTANCE = Mappers.getMapper(OrgEntityMapStruct.class);

    List<OrgTreeDto> orgToOrgTreeDto(List<Org> orgList);


    Org orgParamToOrg(OrgParam orgParam);
}
