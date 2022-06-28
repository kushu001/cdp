package com.chomolungma.system.org.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrgMapper extends BaseMapper<OrgEntity> {
    List<OrgEntity> selectVo(OrgEntity orgEntity);
}
