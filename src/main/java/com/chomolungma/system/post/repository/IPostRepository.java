package com.chomolungma.system.post.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.post.domain.entity.PostEntity;

import java.util.List;

public interface IPostRepository {
    Void save(PostEntity postEntity);
    IPage<PostEntity> query(Page<?> page, PostEntity postEntity);
    PostEntity query(Long id);

    Void remove(List<String> ids);
}
