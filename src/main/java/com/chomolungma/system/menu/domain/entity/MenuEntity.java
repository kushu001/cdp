package com.chomolungma.system.menu.domain.entity;

import com.chomolungma.core.domain.entity.BaseEntity;
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
    private String type;
}
