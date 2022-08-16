package com.chomolungma.system.log.domain.entity;

import com.chomolungma.core.domain.entity.BaseEntity;
import lombok.Data;

@Data
public class OperateLogEntity extends BaseEntity {
    private String user;
    private String url;
    private String requestMethod;
    private String resourceName;
    private String pathPayload;
    private String payload;
}
