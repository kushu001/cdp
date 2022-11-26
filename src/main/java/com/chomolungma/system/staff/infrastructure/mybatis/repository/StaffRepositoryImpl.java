package com.chomolungma.system.staff.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.system.staff.domain.entity.Org;
import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.domain.repository.IStaffRepository;
import com.chomolungma.system.staff.infrastructure.adapter.OrgAdapter;
import com.chomolungma.system.staff.infrastructure.converter.StaffConverter;
import com.chomolungma.system.staff.infrastructure.dataobject.OrgStaffDO;
import com.chomolungma.system.staff.infrastructure.dataobject.StaffDO;
import com.chomolungma.system.staff.infrastructure.mybatis.repository.mapper.OrgStaffMapper;
import com.chomolungma.system.staff.infrastructure.mybatis.repository.mapper.StaffMapper;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import org.springframework.stereotype.Repository;

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
    public List<StaffDTO> getStaffs(String code, Staff staff) {
        return staffMapper.selectStaffsByCondition(code, StaffConverter.INSTANCE.toDO(staff));
    }

    @Override
    public void save(Staff staff) {
        // 转换成DO
        StaffDO staffDO = StaffConverter.INSTANCE.toDO(staff);

        if (staffDO.getId() == null){
            // 新增用户
            staffMapper.insert(staffDO);
            //新增用户关联
            OrgStaffDO orgStaffDO = new OrgStaffDO();
            orgStaffDO.setOrgId(staff.getOrg().getId());
            orgStaffDO.setUserId(staffDO.getId());
            orgStaffMapper.insert(orgStaffDO);
        }else{
            staffMapper.updateById(staffDO);
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
        OrgStaffDO orgStaffDO = orgStaffMapper.selectOne(new QueryWrapper<OrgStaffDO>().eq("user_id", staffDO.getId()));
        Org org = orgAdapter.adapter(orgStaffDO.getOrgId());
        Staff staff = StaffConverter.INSTANCE.toEntity(staffDO);
        staff.setOrg(org);
        return staff;
    }
}
