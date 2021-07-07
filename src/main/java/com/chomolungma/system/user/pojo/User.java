package com.chomolungma.system.user.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.system.common.pojo.BaseBean;
import lombok.Data;

@Data
@TableName("sys_user")
public class User extends BaseBean {

    private String name;
    private String gender;
    private String tel;
    private String addr;
    private String company;
    private String status;
}
