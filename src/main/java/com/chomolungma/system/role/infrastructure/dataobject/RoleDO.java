package com.chomolungma.system.role.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
@TableName("sys_role")
public class RoleDO extends BaseDO {
    private String name;
    private String code;
    private String remark;
    private Integer status;
}
