package com.chomolungma.system.org.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrgMapper extends BaseMapper<OrgDO> {
    List<OrgEntity> selectVo(OrgEntity orgEntity);
}
