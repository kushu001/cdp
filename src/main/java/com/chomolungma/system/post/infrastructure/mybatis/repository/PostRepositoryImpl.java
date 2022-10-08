package com.chomolungma.system.post.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.post.domain.entity.PostEntity;
import com.chomolungma.system.post.domain.repository.IPostRepository;
import com.chomolungma.system.post.infrastructure.converter.PostConverter;
import com.chomolungma.system.post.infrastructure.dataobject.PostDO;
import com.chomolungma.system.post.infrastructure.mybatis.repository.mapper.PostMapper;
import com.chomolungma.system.post.interfaces.dto.PostPageDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class PostRepositoryImpl implements IPostRepository {

    private final PostMapper postMapper;

    public PostRepositoryImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public Void save(PostEntity postEntity) {
        PostDO postDO = PostConverter.INSTANCE.toDO(postEntity);
        if (StringUtils.isEmpty(postDO.getId())){
            postMapper.insert(postDO);
        }else{
            postMapper.updateById(postDO);
        }
        return null;
    }
    @Override
    public PostPageDTO query(int current, int size, String name, String code) {
        PageHelper.startPage(current, size);
        List<PostDO> postDOS = postMapper.selectList(new QueryWrapper<PostDO>().like(name !=null, "name", name).like(code != null, "code", code));
        PageInfo<PostDO> pageInfo = new PageInfo<>(postDOS);
        return PostConverter.INSTANCE.toDTO(pageInfo);
    }

    @Override
    public PostEntity query(Long id) {
        return PostConverter.INSTANCE.toEntity(postMapper.selectById(id));
    }

    @Override
    public Void remove(List<String> ids) {
        postMapper.deleteBatchIds(ids);
        return null;
    }
}
