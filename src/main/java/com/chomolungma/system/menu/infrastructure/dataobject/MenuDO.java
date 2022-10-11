package com.chomolungma.system.menu.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
@TableName(value = "sys_menu")
public class MenuDO extends BaseDO {
    private String code;
    private String pCode;
    private Long pid;
    private String title;
    private String name;
    private String icon;
    private String url;
    private String permission;
    private Boolean hasLeaf;
    private String type;
}
