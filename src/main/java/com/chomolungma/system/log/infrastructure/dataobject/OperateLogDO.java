package com.chomolungma.system.log.infrastructure.dataobject;

import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
public class OperateLogDO extends BaseDO {
    private String user;
    private String url;
    private String requestMethod;
    private String resourceName;
    private String pathPayload;
    private String payload;
}
