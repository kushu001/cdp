package com.chomolungma.system.post.repository.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.post.domain.entity.PostEntity;
import com.chomolungma.system.post.repository.dataobject.PostDO;
import com.chomolungma.system.post.repository.dataobject.QueryPostDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostConverter {
    PostConverter INSTANCE = Mappers.getMapper(PostConverter.class);
    Page<PostEntity> toIPage(IPage<QueryPostDO> queryPostDOIPage);
    PostDO toDO(PostEntity postEntity);

    PostEntity toEntity(PostDO postDO);
}
