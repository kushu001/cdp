package com.chomolungma.system.staff.interfaces.assembler;


import com.chomolungma.system.staff.domain.entity.Org;
import com.chomolungma.system.staff.domain.entity.Post;
import com.chomolungma.system.staff.interfaces.dto.StaffSearchDTO;
import com.chomolungma.system.staff.interfaces.mapstruct.StaffEntityMapStruct;
import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.interfaces.dto.PageStaffDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffFormDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.stream.Collectors;


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
        StaffDTO staffDTO = StaffEntityMapStruct.INSTANCE.toDTO(staff);
        List<Long> orgIds = staff.getOrgs().stream().map(Org::getId).collect(Collectors.toList());
        staffDTO.setOrgIds(orgIds);
        String orgNames = staff.getOrgs().stream().map(Org::getName).collect(Collectors.joining(","));
        staffDTO.setOrgNames(orgNames);

        List<Long> postIds = staff.getPosts().stream().map(Post::getId).collect(Collectors.toList());
        staffDTO.setPostIds(postIds);
        String postNames = staff.getPosts().stream().map(Post::getName).collect(Collectors.joining(","));
        staffDTO.setPostNames(postNames);
        return staffDTO;
    }

}
