package com.chomolungma.system.menu.interfaces.dto;

import com.chomolungma.core.interfaces.dto.BaseDTO;
import lombok.Data;

@Data
public class MenuDTO extends BaseDTO {
    private String code;
    private String pCode;
    private Long pid;
    private String title;
    private String name;
    private String url;
    private String icon;
    private String permission;
    private Boolean hasLeaf;
    private String sort;
    private String type;
}
