package com.chomolungma.system.resource.domain.entity;

import com.chomolungma.core.entity.BaseEntity;
import lombok.Data;

@Data
public class ResourceEntity extends BaseEntity {
    private String name;
    private String sign;
    private String url;
}
