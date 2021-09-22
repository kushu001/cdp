package com.chomolungma.system.org.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.system.common.pojo.BaseBean;
import lombok.Data;

@Data
@TableName("sys_org")
public class OrgEntity extends BaseBean {

    private Long pid;
    private String name;
    private String manager;
    private Long managerId;
    private String tel;
    @TableField("`order`")
    private Integer order;
    private String status;
}
