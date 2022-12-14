package com.chomolungma.system.org.domain.entity;

import com.chomolungma.core.entity.BaseEntity;
import lombok.Data;

@Data
public class OrgEntity extends BaseEntity {
    private Long pid;
    private String name;
    private String code;
    private String manager;
    private Long managerId;
    private String tel;
    private Integer order;
}
