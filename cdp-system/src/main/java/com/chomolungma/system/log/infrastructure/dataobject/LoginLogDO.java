package com.chomolungma.system.log.infrastructure.dataobject;

import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
public class LoginLogDO extends BaseDO {
    private String user;
    private String address;
    private String client;
    private String os;
    private String ip;
}
