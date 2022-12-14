package com.chomolungma.system.role.interfaces.dto;

import lombok.Data;

@Data
public class OutRoleFormDTO {
    private Long id;
    private String name;
    private String code;
    private String remark;
    private Boolean enabled;
    private Integer status;
}
