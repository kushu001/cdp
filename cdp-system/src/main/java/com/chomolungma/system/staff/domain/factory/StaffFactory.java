package com.chomolungma.system.staff.domain.factory;

import com.chomolungma.system.staff.domain.entity.Org;
import com.chomolungma.system.staff.domain.entity.Post;
import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.domain.repository.IStaffRepository;
import com.chomolungma.system.staff.interfaces.assembler.StaffAssembler;
import com.chomolungma.system.staff.interfaces.dto.StaffFormDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StaffFactory {
    private final IStaffRepository iStaffRepository;

    public StaffFactory(IStaffRepository iStaffRepository){
        this.iStaffRepository = iStaffRepository;
    }

    public Staff createStaff(StaffFormDTO staffFormDTO){
        Staff staff = StaffAssembler.toEntity(staffFormDTO);
        List<Long> postIds = staffFormDTO.getPostIds();
        List<Post> posts = iStaffRepository.findPosts(postIds);
        List<Org> orgs = iStaffRepository.findOrgs(staffFormDTO.getOrgIds());
        staff.setOrgs(orgs);
        staff.setPosts(posts);
        return staff;
    }
}
