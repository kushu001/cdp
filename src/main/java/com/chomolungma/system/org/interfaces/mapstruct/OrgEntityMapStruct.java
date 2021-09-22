package com.chomolungma.system.org.interfaces.mapstruct;

import com.chomolungma.system.org.interfaces.dto.OrgTreeDto;
import com.chomolungma.system.org.interfaces.param.OrgParam;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrgEntityMapStruct {
    OrgEntityMapStruct INSTANCE = Mappers.getMapper(OrgEntityMapStruct.class);

    List<OrgTreeDto> orgToOrgTreeDto(List<OrgEntity> orgEntityList);


    OrgEntity orgParamToOrg(OrgParam orgParam);
}
