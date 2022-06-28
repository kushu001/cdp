package com.chomolungma.system.role.interfaces.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

import java.util.Date;

@Data
public class InRoleSearchDTO extends PageDTO {
    public String name;
    public String code;
    public String remark;
    public Integer status;
    public Date startTime;
    public Date endTime;

}
