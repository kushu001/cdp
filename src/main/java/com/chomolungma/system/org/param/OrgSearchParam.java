package com.chomolungma.system.org.param;

import lombok.Data;

@Data
public class OrgSearchParam {
    private String name;
    private String manager;
    private Long managerId;
    private String tel;
    private String status;
}
