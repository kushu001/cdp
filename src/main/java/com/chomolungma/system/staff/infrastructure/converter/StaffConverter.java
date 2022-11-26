package com.chomolungma.system.staff.infrastructure.converter;

import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.infrastructure.dataobject.StaffDO;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffConverter {
    StaffConverter INSTANCE = Mappers.getMapper(StaffConverter.class);

    StaffDO toDO(Staff staff);

    Staff toEntity(StaffDO staffDO);

    StaffDTO toDTO(StaffDO staffDO);

}
