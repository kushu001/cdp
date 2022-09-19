package com.chomolungma.system.user.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@TableName(value = "sys_user")
@Data
public class UserDO extends BaseDO {
    private String name;
    private String gender;
    private String tel;
    private String phone;
    private String idNumber;
    private String address;
    private String company;
}
