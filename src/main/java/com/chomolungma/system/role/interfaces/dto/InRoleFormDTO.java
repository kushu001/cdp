package com.chomolungma.system.role.interfaces.dto;

import lombok.Data;

@Data
public class InRoleFormDTO {
    public Long id;
    public String name;
    public String code;
    public String remark;
    public Integer status;
}
