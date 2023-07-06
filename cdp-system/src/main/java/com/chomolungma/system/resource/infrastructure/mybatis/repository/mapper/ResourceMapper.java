package com.chomolungma.system.resource.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.resource.infrastructure.dataobject.ResourceDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourceMapper extends BaseMapper<ResourceDO> {
    List<ResourceDO> selectList(ResourceDO resourceDO);
}
