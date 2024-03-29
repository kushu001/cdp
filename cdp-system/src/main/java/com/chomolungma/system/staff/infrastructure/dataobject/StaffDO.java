package com.chomolungma.system.staff.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@TableName(value = "sys_user")
@Data
public class StaffDO extends BaseDO {
    private String code;
    private String name;
    private String gender;
    private String tel;
    private String phone;
    private String email;
    private String idNumber;
    private String address;
    private String homeAddress;
    private String company;
}
