package com.chomolungma.system.post.application.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.post.domain.entity.PostEntity;

public interface PostService {
    IPage<PostEntity> pageList(Page<?> page, PostEntity postEntity);
}
