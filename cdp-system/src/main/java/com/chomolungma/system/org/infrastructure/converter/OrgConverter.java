package com.chomolungma.system.org.infrastructure.converter;

import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import com.chomolungma.system.org.interfaces.dto.OrgDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrgConverter {
    OrgConverter INSTANCE = Mappers.getMapper(OrgConverter.class);

    OrgEntity toEntity(OrgDO orgDO);

    OrgDO toDO(OrgDTO orgDTO);

    OrgDO toDO(OrgEntity org);

    List<OrgEntity> toEntity(List<OrgDO> orgDOS);
}
