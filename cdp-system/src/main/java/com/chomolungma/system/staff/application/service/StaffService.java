package com.chomolungma.system.staff.application.service;

import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.interfaces.dto.PageStaffDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffFormDTO;

import java.util.List;

public interface StaffService {
    PageStaffDTO getStaffs(Long orgId, String name, String idNumber, String phone, String tel, String address, Integer status, Integer page, Integer limit);
    List<StaffDTO> getStaffs(Long orgId, String name, String idNumber, String phone, String tel, String address);
    StaffDTO getStaff(Long id);
    void createStaff(Long orgId, StaffFormDTO staffFormDTO);
    void updateStaff(StaffFormDTO staffFormDTO);
    void deleteStaffs(List<String> ids);
    List<MenuDTO> getMenus(List<Long> roleIds);
    void audit(Long userId);
}
