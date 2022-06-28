package com.chomolungma.system.menu.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.domain.entity.BaseEntity;
import lombok.Data;

@Data
@TableName(value = "sys_menu")
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
