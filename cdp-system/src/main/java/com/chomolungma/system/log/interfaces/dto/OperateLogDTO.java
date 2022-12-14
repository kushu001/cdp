package com.chomolungma.system.log.interfaces.dto;

import com.chomolungma.core.dto.PageDTO;
import lombok.Data;

@Data
public class OperateLogDTO extends PageDTO {
    private String user;
    private String url;
    private String requestMethod;
    private String resourceName;
    private String pathPayload;
    private String payload;
}
