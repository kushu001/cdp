package com.chomolungma.system.staff.domain.repository;

import com.chomolungma.system.staff.domain.entity.Org;
import com.chomolungma.system.staff.domain.entity.Post;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import com.chomolungma.system.staff.domain.entity.Staff;

import java.util.List;

public interface IStaffRepository {
    List<StaffDTO> findStaffs(Long orgId, Staff staff);
    void save(Staff staff);
    void remove(List<Long> ids);
    Staff findStaff(String idNumber);
    Staff findStaff(Long id);
    List<Post> findPosts(List<Long> ids);
    List<Org> findOrgs(List<Long> ids);
}
