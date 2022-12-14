package com.chomolungma.system.staff.interfaces.assembler;


import com.chomolungma.system.staff.interfaces.dto.StaffSearchDTO;
import com.chomolungma.system.staff.interfaces.mapstruct.StaffEntityMapStruct;
import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.interfaces.dto.PageStaffDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffFormDTO;
import com.github.pagehelper.PageInfo;


public class StaffAssembler {

    public static PageStaffDTO toPageUserDTO(PageInfo<StaffDTO> userOrgDOPageInfo){
        return StaffEntityMapStruct.INSTANCE.toPageUserDTO(userOrgDOPageInfo);
    }

    public static Staff toEntity(StaffFormDTO staffFormDTO){
        return StaffEntityMapStruct.INSTANCE.toEntity(staffFormDTO);
    }

    public static Staff toEntity(StaffSearchDTO staffSearchDTO){
        return StaffEntityMapStruct.INSTANCE.toEntity(staffSearchDTO);
    }

    public static StaffDTO toDTO(Staff staff){
        return StaffEntityMapStruct.INSTANCE.toDTO(staff);
    }

}
