package com.chomolungma.system.resource.application.impl;

import com.chomolungma.system.resource.application.ResourceService;
import com.chomolungma.system.resource.domain.entity.ResourceEntity;
import com.chomolungma.system.resource.domain.repository.IResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {
    private IResourceRepository iResourceRepository;
    public ResourceServiceImpl(IResourceRepository iResourceRepository){
        this.iResourceRepository = iResourceRepository;
    }
    @Override
    public void create(ResourceEntity resourceEntity) {
        iResourceRepository.save(resourceEntity);
    }

    @Override
    public void modify(ResourceEntity resourceEntity) {
        iResourceRepository.save(resourceEntity);
    }

}
