package com.chomolungma.system.resource.application;

import com.chomolungma.system.resource.domain.entity.ResourceEntity;

public interface ResourceService {
    void create(ResourceEntity resourceEntity);

    void modify(ResourceEntity resourceEntity);
}
