package com.chomolungma.role.bo;

import com.chomolungma.common.param.BaseBO;
import lombok.Data;

@Data
public class InRoleFormBO {
    public Long id;
    public String name;
    public String code;
    public Integer status;
}
