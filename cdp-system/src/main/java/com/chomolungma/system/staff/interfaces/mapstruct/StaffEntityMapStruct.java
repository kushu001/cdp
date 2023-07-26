package com.chomolungma.system.staff.interfaces.mapstruct;


import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.interfaces.dto.PageStaffDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffFormDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffSearchDTO;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface StaffEntityMapStruct {
    StaffEntityMapStruct INSTANCE = Mappers.getMapper(StaffEntityMapStruct.class);

    @Mappings({
        @Mapping(target = "records", source = "list"),
        @Mapping(target = "page", source = "pageNum")
    })
    PageStaffDTO toPageUserDTO(PageInfo<StaffDTO> pageUsers);
    Staff toEntity(StaffFormDTO staffFormDTO);
    Staff toEntity(StaffSearchDTO staffSearchDTO);
    StaffDTO toDTO(Staff staff);

}
