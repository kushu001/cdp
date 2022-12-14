package com.chomolungma.system.org.interfaces.param;

import lombok.Data;

@Data
public class OrgParam {
    private Long id;
    private Long pid = 0l;
    private String name;
    private String code;
    private String manager;
    private Long managerId;
    private String tel;
    private Integer order;
    private String status;
}
