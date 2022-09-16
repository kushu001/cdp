package com.chomolungma.system.org.infrastructure.converter;

import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import com.chomolungma.system.org.pojo.Org;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrgConverter {
    OrgConverter INSTANCE = Mappers.getMapper(OrgConverter.class);

    Org toEntity(OrgDO orgDO);
}
