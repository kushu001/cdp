package com.chomolungma.system.post.domain.repository;

import com.chomolungma.system.post.interfaces.dto.PostPageDTO;
import com.chomolungma.system.post.domain.entity.PostEntity;

import java.util.List;

public interface IPostRepository {
    Void save(PostEntity postEntity);
    PostPageDTO find(int current, int size, String name, String code);
    PostEntity find(Long id);

    Void remove(List<String> ids);
}
