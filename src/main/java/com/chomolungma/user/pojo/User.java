package com.chomolungma.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.common.pojo.BaseBean;
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
