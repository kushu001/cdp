package com.chomolungma.system.staff.domain.service;

import com.chomolungma.core.exception.BusinessRuntimeException;
import com.chomolungma.system.staff.domain.repository.IStaffRepository;
import com.chomolungma.system.staff.domain.entity.Staff;
import com.chomolungma.system.staff.domain.service.impl.IStaffDomainService;
import org.springframework.stereotype.Service;

@Service
public class StaffDomainServiceImpl implements IStaffDomainService {
    private final IStaffRepository iStaffRepository;
    public StaffDomainServiceImpl(IStaffRepository iStaffRepository){
        this.iStaffRepository = iStaffRepository;
    }
    @Override
    public void addStaff(Staff staff) {
        Staff isStaff = iStaffRepository.findStaff(staff.getIdNumber());
        if (isStaff != null) {
            throw new BusinessRuntimeException("用户身份证号已存在，请查证后再建！");
        } else {
            iStaffRepository.save(staff);
        }
    }

    @Override
    public void modifyStaff(Staff staff) {
        iStaffRepository.save(staff);
    }

}
