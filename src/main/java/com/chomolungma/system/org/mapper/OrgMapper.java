package com.chomolungma.system.org.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.org.pojo.Org;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrgMapper extends BaseMapper<Org> {
    IPage<Org> selectPageVo(Page<?> page, @Param("org") Org org);

    List<Org> selectVo(Org org);
}
