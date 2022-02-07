package com.chomolungma.role.bo;

import com.chomolungma.common.param.PageBO;
import lombok.Data;

import java.util.Date;

@Data
public class InRoleSearchBO extends PageBO {
    public String name;
    public String code;
    public Integer status;
    public Date startTime;
    public Date endTime;

}
