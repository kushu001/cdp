package com.chomolungma.system.dict.domain.entity;

import com.chomolungma.core.entity.BaseEntity;
import lombok.Data;

@Data
public class DictItemEntity extends BaseEntity {
    private Long dictId;
    private String code;
    private String name;
    private String value;
    private Integer sort;
    private Boolean enabled;
}
