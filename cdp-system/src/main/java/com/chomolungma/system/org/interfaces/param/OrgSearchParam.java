package com.chomolungma.system.org.interfaces.param;

import lombok.Data;

@Data
public class OrgSearchParam {
    private String name;
    private String code;
    private String manager;
    private Long managerId;
    private String tel;
    private String status;
}
