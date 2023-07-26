package com.chomolungma.system.staff.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.core.exception.BusinessRuntimeException;
import com.chomolungma.system.staff.domain.entity.Post;
import com.chomolungma.system.staff.infrastructure.converter.StaffConverter;
import com.chomolungma.system.staff.infrastructure.dataobject.OrgStaffDO;
import com.chomolungma.system.staff.infrastructure.dataobject.OrgWithStaffDO;
import com.chomolungma.system.staff.infrastructure.dataobject.PostWithStaffDO;
import com.chomolungma.system.staff.infrastructure.dataobject.StaffDO;
import com.chomolungma.system.staff.infrastructure.mybatis.repository.mapper.StaffMapper;
import com.chomolungma.system.staff.domain.entity.Org;
import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.domain.repository.IStaffRepository;
import com.chomolungma.system.staff.infrastructure.adapter.OrgAdapter;
import com.chomolungma.system.staff.infrastructure.mybatis.repository.mapper.OrgStaffMapper;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StaffRepositoryImpl implements IStaffRepository {
    private final StaffMapper staffMapper;
    private final OrgStaffMapper orgStaffMapper;
    private final OrgAdapter orgAdapter;

    public StaffRepositoryImpl(StaffMapper staffMapper, OrgStaffMapper orgStaffMapper, OrgAdapter orgAdapter) {
        this.staffMapper = staffMapper;
        this.orgStaffMapper = orgStaffMapper;
        this.orgAdapter = orgAdapter;
    }


    @Override
    public List<StaffDTO> findStaffs(Long orgId, Staff staff) {
        StaffDO staffDO = StaffConverter.INSTANCE.toDO(staff);
        return staffMapper.selectStaffsByCondition(orgId, staffDO);
    }

    @Override
    @Transactional
    public void save(Staff staff) {
        // 转换成DO
        StaffDO staffDO = StaffConverter.INSTANCE.toDO(staff);

        if (staffDO.getId() == null){
            // 新增用户
            staffMapper.insert(staffDO);
            //新增用户职位关联
            staffMapper.saveStaffAndPosts(staffDO.getId(), StaffConverter.INSTANCE.toDO(staff.getPosts()));
            //新增用户部门关联
            staffMapper.saveStaffAndOrgs(staffDO.getId(), StaffConverter.INSTANCE.toOrgDO(staff.getOrgs()));
        }else{
            staffMapper.updateById(staffDO);
            //更新用户职位关联
            staffMapper.deleteStaffAndPosts(staffDO.getId());
            staffMapper.saveStaffAndPosts(staffDO.getId(), StaffConverter.INSTANCE.toDO(staff.getPosts()));
            //更新用户部门关联
            staffMapper.deleteStaffAndOrgs(staffDO.getId());
            staffMapper.saveStaffAndOrgs(staffDO.getId(), StaffConverter.INSTANCE.toOrgDO(staff.getOrgs()));
        }
    }

    @Override
    public void remove(List<Long> ids) {
        Boolean count = staffMapper.noDeleteCount(ids);
        if (count){
            if (ids.size()>1){
                throw new BusinessRuntimeException("含有[通过]状态的人员数据，无法删除！");
            }else{
                throw new BusinessRuntimeException("当前人员数据状态为[通过]，无法删除！");
            }

        }
        // 删除用户信息
        staffMapper.deleteBatchIds(ids);
        // 删除用户部门关联信息
        orgStaffMapper.delete(new QueryWrapper<OrgStaffDO>().in("user_id", ids));
    }

    @Override
    public Staff findStaff(String idNumber) {
        return StaffConverter.INSTANCE.toEntity(staffMapper.selectOne(new QueryWrapper<StaffDO>().eq("id_number", idNumber)));
    }

    @Override
    public Staff findStaff(Long id) {
        StaffDO staffDO = staffMapper.selectById(id);
        Staff staff = StaffConverter.INSTANCE.toEntity(staffDO);
        // 查询人员关联部门
        List<OrgWithStaffDO> orgs = staffMapper.selectOrgByStaffId(id);
        staff.setOrgs(StaffConverter.INSTANCE.toOrgEntity(orgs));
        // 查询人员关联职位
        List<PostWithStaffDO> postWithStaffDOS = staffMapper.selectPostByStaffId(id);
        staff.setPosts(StaffConverter.INSTANCE.toEntity(postWithStaffDOS));
        return staff;
    }

    @Override
    public List<Post> findPosts(List<Long> ids) {
        List<PostWithStaffDO> postsDOS = staffMapper.selectPostWithStaff(ids);
        return StaffConverter.INSTANCE.toEntity(postsDOS);
    }

    @Override
    public List<Org> findOrgs(List<Long> ids) {
        List<OrgWithStaffDO> orgWithStaffDOS = staffMapper.selectOrgWithStaff(ids);
        return StaffConverter.INSTANCE.toOrgEntity(orgWithStaffDOS);
    }
}
