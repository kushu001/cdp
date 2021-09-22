package com.chomolungma.system.org.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrgMapper extends BaseMapper<OrgEntity> {
    IPage<OrgEntity> selectPageVo(Page<?> page, @Param("org") OrgEntity orgEntity);

    List<OrgEntity> selectVo(OrgEntity orgEntity);
}
