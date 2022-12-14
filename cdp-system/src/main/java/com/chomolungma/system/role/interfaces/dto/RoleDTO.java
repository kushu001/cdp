package com.chomolungma.system.role.interfaces.dto;

import com.chomolungma.core.dto.BaseDTO;
import lombok.Data;

@Data
public class RoleDTO extends BaseDTO {
    private String name;
    private String code;
    private Boolean enabled;
    private String remark;
}
