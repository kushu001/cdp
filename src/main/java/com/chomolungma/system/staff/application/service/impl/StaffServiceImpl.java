package com.chomolungma.system.staff.application.service.impl;

import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.role.domain.service.GetMenuDomainService;
import com.chomolungma.system.staff.application.service.StaffService;
import com.chomolungma.system.staff.domain.entity.Org;
import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.domain.repository.IStaffRepository;
import com.chomolungma.system.staff.domain.service.impl.IStaffDomainService;
import com.chomolungma.system.staff.infrastructure.adapter.OrgAdapter;
import com.chomolungma.system.staff.interfaces.assembler.StaffAssembler;
import com.chomolungma.system.staff.interfaces.dto.PageStaffDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffDTO;
import com.chomolungma.system.staff.interfaces.dto.StaffFormDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {
    private final GetMenuDomainService getMenuDomainService;
    private final IStaffRepository iStaffRepository;
    private final IStaffDomainService iStaffDomainService;
    private final OrgAdapter orgAdapter;

    public StaffServiceImpl(GetMenuDomainService getMenuDomainService, IStaffRepository iStaffRepository, IStaffDomainService iStaffDomainService, OrgAdapter orgAdapter) {
        this.getMenuDomainService = getMenuDomainService;
        this.iStaffRepository = iStaffRepository;
        this.iStaffDomainService = iStaffDomainService;
        this.orgAdapter = orgAdapter;
    }

    @Override
    public PageStaffDTO getStaffs(String code, String name, String idNumber, String phone, String tel, String address, Integer page, Integer limit) {
        Staff staff = new Staff();
        staff.setName(name);
        staff.setIdNumber(idNumber);
        staff.setPhone(phone);
        staff.setTel(tel);
        staff.setAddress(address);
        PageHelper.startPage(page, limit);
        List<StaffDTO> userOrgDOS = iStaffRepository.getStaffs(code, staff);
        PageInfo<StaffDTO> pageInfo = new PageInfo<>(userOrgDOS);
        return StaffAssembler.toPageUserDTO(pageInfo);
    }

    @Override
    public StaffDTO getStaff(Long id) {
        Staff staff  = iStaffRepository.findStaff(id);
        return StaffAssembler.toDTO(staff);
    }

    @Override
    public void createStaff(Long orgId, StaffFormDTO staffFormDTO) {
        Staff staff = StaffAssembler.toEntity(staffFormDTO);
        Org org = orgAdapter.adapter(orgId);
        staff.setOrg(org);
        iStaffDomainService.addStaff(staff);
    }

    @Override
    public void updateStaff(Staff staff) {
        iStaffDomainService.modifyStaff(staff);
    }

    @Override
    public void deleteStaffs(String code, List<String> ids) {
        iStaffRepository.remove(ids.stream().map(Long::valueOf).collect(Collectors.toList()));
    }
    @Override
    public List<MenuDTO> getMenus(List<Long> roleIds) {
        return getMenuDomainService.getMenusByRoleIds(roleIds);
    }

    @Override
    public List<StaffDTO> getStaffs(String code, String name, String idNumber, String phone, String tel, String address) {
        Staff staff = new Staff();
        staff.setName(name);
        staff.setIdNumber(idNumber);
        staff.setPhone(phone);
        staff.setTel(tel);
        staff.setAddress(address);
        return iStaffRepository.getStaffs(code, staff);
    }

    @Override
    public void audit(Long staffId) {
        Staff staff = iStaffRepository.findStaff(staffId);
        staff.audit();
        iStaffRepository.save(staff);
    }
}
