package com.chomolungma.system.menu.param;

import lombok.Data;

@Data
public class MenuParam {
    private Long id;
    private Long pid;
    private String name;
    private String title;
    private String url;
    private String icon;
    private String sort;
    private String type;
    private String permission;
    private String status;
}
