package com.chomolungma.system.post.domain.entity;

import com.chomolungma.core.entity.BaseEntity;
import lombok.Data;

@Data
public class PostEntity extends BaseEntity {
    private String name;
    private String code;
    private String type;
    private String typeName;
    private Integer sort;
}
