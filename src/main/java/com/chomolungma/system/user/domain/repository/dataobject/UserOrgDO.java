package com.chomolungma.system.user.domain.repository.dataobject;

import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
public class UserOrgDO extends BaseDO {
    private String name;
    private String gender;
    private String tel;
    private String phone;
    private String address;
    private String company;
    private String deptId;
    private String deptName;
}
