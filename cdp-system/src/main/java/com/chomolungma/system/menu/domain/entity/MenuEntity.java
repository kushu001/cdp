package com.chomolungma.system.menu.domain.entity;

import com.chomolungma.core.entity.BaseEntity;
import lombok.Data;

@Data
public class MenuEntity extends BaseEntity {
    private String code;
    private String pCode;
    private Long pid;
    private String title;
    private String name;
    private String url;
    private String icon;
    private String sort;
    private String permission;
    private Boolean hasLeaf = false;
    private String type;
    private Boolean enabled;
}
