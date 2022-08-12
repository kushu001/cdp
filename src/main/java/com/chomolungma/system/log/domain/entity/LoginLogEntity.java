package com.chomolungma.system.log.domain.entity;

import com.chomolungma.core.domain.entity.BaseEntity;
import lombok.Data;

@Data
public class LoginLogEntity extends BaseEntity {
    private String user;
    private String address;
    private String ip;
    private String client;
    private String os;
}
