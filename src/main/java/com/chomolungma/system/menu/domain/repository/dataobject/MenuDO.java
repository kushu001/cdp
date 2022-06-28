package com.chomolungma.system.menu.domain.repository.dataobject;

import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
public class MenuDO extends BaseDO {
    private String code;
    private String pCode;
    private Long pid;
    private String title;
    private String name;
    private String icon;
    private String url;
    private String type;
}
