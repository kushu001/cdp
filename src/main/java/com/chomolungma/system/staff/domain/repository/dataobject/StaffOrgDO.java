package com.chomolungma.system.staff.domain.repository.dataobject;

import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
public class StaffOrgDO extends BaseDO {
    private String name;
    private String idNumber;
    private String gender;
    private String tel;
    private String phone;
    private String address;
    private String company;
    private String deptId;
    private String deptName;
}
