package com.chomolungma.system.staff.infrastructure.converter;

import com.chomolungma.system.staff.domain.entity.Org;
import com.chomolungma.system.staff.domain.entity.Post;
import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.infrastructure.dataobject.OrgWithStaffDO;
import com.chomolungma.system.staff.infrastructure.dataobject.PostWithStaffDO;
import com.chomolungma.system.staff.infrastructure.dataobject.StaffDO;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StaffConverter {
    StaffConverter INSTANCE = Mappers.getMapper(StaffConverter.class);

    StaffDO toDO(Staff staff);

    Staff toEntity(StaffDO staffDO);

    StaffDTO toDTO(StaffDO staffDO);

    List<Post> toEntity(List<PostWithStaffDO> postWithStaffDOS);
    List<Org> toOrgEntity(List<OrgWithStaffDO> orgWithStaffDOS);

    List<PostWithStaffDO> toDO(List<Post> posts);
    List<OrgWithStaffDO> toOrgDO(List<Org> orgs);

}
