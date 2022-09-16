package com.chomolungma.system.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.domain.entity.BaseEntity;
import lombok.Data;

@Data
@TableName(value = "sys_user")
public class UserEntity extends BaseEntity {
    private String name;
    private Integer gender;
    private String idNumber;
    private String tel;
    private String phone;
    private String address;
    private String company;
    @TableField(exist = false)
    private Long deptId;
    @TableField(exist = false)
    private String deptName;
}
