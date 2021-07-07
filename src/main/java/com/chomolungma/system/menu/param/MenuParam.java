package com.chomolungma.system.menu.param;

import lombok.Data;

@Data
public class MenuParam {
    private Long id;
    private Long pid;
    private String name;
    private String url;
    private String icon;
    private Integer order;
    private String status;
}
