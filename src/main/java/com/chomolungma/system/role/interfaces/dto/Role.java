package com.chomolungma.system.role.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private Long id;
    private String name;
    private String code;
    private String remark;
    private Boolean enabled;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
