package com.chomolungma.system.post.application.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.post.application.service.PostService;
import com.chomolungma.system.post.domain.entity.PostEntity;
import com.chomolungma.system.post.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private IPostRepository iPostRepository;

    @Override
    public IPage<PostEntity> pageList(Page<?> page, PostEntity postEntity) {
        return iPostRepository.query(page, postEntity);
    }
}
