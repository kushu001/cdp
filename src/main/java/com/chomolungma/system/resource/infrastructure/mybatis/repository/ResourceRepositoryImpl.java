package com.chomolungma.system.resource.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.resource.domain.entity.ResourceEntity;
import com.chomolungma.system.resource.domain.repository.IResourceRepository;
import com.chomolungma.system.resource.infrastructure.converter.ResourceConverter;
import com.chomolungma.system.resource.infrastructure.dataobject.ResourceDO;
import com.chomolungma.system.resource.infrastructure.mybatis.repository.mapper.ResourceMapper;
import com.chomolungma.system.resource.interfaces.dto.ResourcePageDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceRepositoryImpl implements IResourceRepository {
    private ResourceMapper resourceMapper;

    public ResourceRepositoryImpl(ResourceMapper resourceMapper){
        this.resourceMapper = resourceMapper;
    }

    @Override
    public void save(ResourceEntity resourceEntity) {
        ResourceDO resourceDO = ResourceConverter.INSTANCE.toDO(resourceEntity);
        if (resourceDO.getId() == null) {
            resourceMapper.insert(resourceDO);
        } else {
            resourceMapper.updateById(resourceDO);
        }
    }

    @Override
    public ResourcePageDTO find(int current, int size, String name) {
        PageHelper.startPage(current, size);
        List<ResourceDO> resourceDOS = resourceMapper.selectList(new QueryWrapper<ResourceDO>().like(name != null, "name", name));
        PageInfo<ResourceDO> pageInfo = new PageInfo<>(resourceDOS);
        return ResourceConverter.INSTANCE.toDTO(pageInfo);
    }

    @Override
    public ResourceEntity find(Long id) {
        ResourceDO resourceDO = resourceMapper.selectById(id);
        return ResourceConverter.INSTANCE.toEntity(resourceDO);
    }

    @Override
    public void remove(List<String> ids) {
        resourceMapper.deleteBatchIds(ids);
    }


}
