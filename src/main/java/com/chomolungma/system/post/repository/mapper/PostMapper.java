package com.chomolungma.system.post.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.post.repository.dataobject.PostDO;
import com.chomolungma.system.post.repository.dataobject.QueryPostDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostMapper extends BaseMapper<PostDO> {
    IPage<QueryPostDO> selectPageList(IPage<?> page, @Param("postDO")  PostDO postDO);

}
