package com.chomolungma.system.staff.domain.repository;

import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import com.chomolungma.system.staff.domain.entity.Staff;

import java.util.List;

public interface IStaffRepository {
    List<StaffDTO> findStaffs(String code, Staff staff);
    void save(Staff staff);
    void remove(List<Long> ids);
    Staff findStaff(String idNumber);
    Staff findStaff(Long id);
}
