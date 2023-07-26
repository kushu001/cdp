package com.chomolungma.system.staff.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.staff.infrastructure.dataobject.OrgWithStaffDO;
import com.chomolungma.system.staff.infrastructure.dataobject.PostWithStaffDO;
import com.chomolungma.system.staff.infrastructure.dataobject.StaffDO;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface StaffMapper extends BaseMapper<StaffDO> {
    List<StaffDTO> selectStaffsByCondition(@Param("orgId") Long orgId, @Param("staffDO") StaffDO staffDO);
    Boolean noDeleteCount(List<Long> ids);
    List<PostWithStaffDO> selectPostWithStaff(List<Long> ids);
    List<OrgWithStaffDO> selectOrgWithStaff(List<Long> ids);
    List<PostWithStaffDO> selectPostByStaffId(Long userId);
    List<OrgWithStaffDO> selectOrgByStaffId(Long userId);
    void deleteStaffAndPosts(Long pkUserId);
    void deleteStaffAndOrgs(Long pkUserId);
    void saveStaffAndPosts(@Param("pkUserId") Long pkUserId, @Param("posts") List<PostWithStaffDO> posts);
    void saveStaffAndOrgs(@Param("pkUserId") Long pkUserId, @Param("orgs") List<OrgWithStaffDO> orgs);

}
