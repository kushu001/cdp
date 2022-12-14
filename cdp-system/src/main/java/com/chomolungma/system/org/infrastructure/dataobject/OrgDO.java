package com.chomolungma.system.org.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
@TableName(value = "sys_org")
public class OrgDO extends BaseDO {
    private Long pid;
    private String name;
    private String code;
    private String manager;
    private Long managerId;
    private String tel;
    @TableField("`order`")
    private Integer order;
}
