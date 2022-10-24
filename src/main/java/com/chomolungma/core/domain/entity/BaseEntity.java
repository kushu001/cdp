package com.chomolungma.core.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    private Long id;
    private Date createTime;
    private Date updateTime;
    private Long createUser;
    private Long updateUser;
    private Integer status;
}
