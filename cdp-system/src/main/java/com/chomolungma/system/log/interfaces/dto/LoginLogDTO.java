package com.chomolungma.system.log.interfaces.dto;

import com.chomolungma.core.dto.PageDTO;
import lombok.Data;

@Data
public class LoginLogDTO extends PageDTO {
    private String user;
    private String address;
    private String client;
    private String os;
    private String ip;
}
