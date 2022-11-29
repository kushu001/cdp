package com.chomolungma.system.org.interfaces.mapstruct;

import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import com.chomolungma.system.org.interfaces.dto.OrgDTO;
import com.chomolungma.system.org.interfaces.param.OrgParam;
import com.chomolungma.system.org.interfaces.param.OrgSearchParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrgEntityMapStruct {
    OrgEntityMapStruct INSTANCE = Mappers.getMapper(OrgEntityMapStruct.class);

    List<OrgDTO> toDTO(List<OrgEntity> orgList);

    OrgEntity toEntity(OrgParam orgParam);

    OrgDO toDO(OrgParam orgParam);
}
