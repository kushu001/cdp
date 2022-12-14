package com.chomolungma.system.dict.domain.entity;

import com.chomolungma.core.entity.BaseEntity;
import lombok.Data;

@Data
public class DictEntity extends BaseEntity {
    private String code;
    private String name;
    private String sort;
}
