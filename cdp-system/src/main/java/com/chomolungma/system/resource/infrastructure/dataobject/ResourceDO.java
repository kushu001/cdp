package com.chomolungma.system.resource.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
@TableName("sys_resource")
public class ResourceDO extends BaseDO {
    private String name;
    private String sign;
    private String url;
    private String method;
}
