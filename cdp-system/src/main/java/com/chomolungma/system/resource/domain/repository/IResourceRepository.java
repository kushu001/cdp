package com.chomolungma.system.resource.domain.repository;

import com.chomolungma.system.resource.interfaces.dto.ResourcePageDTO;
import com.chomolungma.system.resource.domain.entity.ResourceEntity;

import java.util.List;

public interface IResourceRepository {
    void save(ResourceEntity resourceEntity);

    ResourcePageDTO find(int current, int size, String name, String sign, String url, String method);

    ResourceEntity find(Long id);

    void remove(List<String> ids);
}
