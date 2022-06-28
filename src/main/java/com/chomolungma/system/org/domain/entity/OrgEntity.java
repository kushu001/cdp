package com.chomolungma.system.org.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.domain.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("sys_org")
public class OrgEntity extends BaseEntity {
    private Long pid;
    private String name;
    private String code;
    private String manager;
    private Long managerId;
   // private String tel;
   // @TableField("`order`")
   // private Integer order;
}
