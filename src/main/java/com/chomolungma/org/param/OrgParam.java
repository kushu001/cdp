package com.chomolungma.org.param;

import lombok.Data;

@Data
public class OrgParam {
    private Long id;
    private Long pid;
    private String name;
    private String manager;
    private Long managerId;
    private String tel;
    private Integer order;
    private String status;
}
