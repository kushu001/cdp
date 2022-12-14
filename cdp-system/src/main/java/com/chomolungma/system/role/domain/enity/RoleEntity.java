package com.chomolungma.system.role.domain.enity;

import lombok.Data;

import java.util.Date;

@Data
public class RoleEntity {
    private Long id;
    private String name;
    private String code;
    private String remark;
    private Boolean enabled;
    private Integer status;
    private Date createTime;
}
