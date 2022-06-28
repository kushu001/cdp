package com.chomolungma.system.post.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.post.repository.converter.PostConverter;
import com.chomolungma.system.post.domain.entity.PostEntity;
import com.chomolungma.system.post.repository.dataobject.PostDO;
import com.chomolungma.system.post.repository.dataobject.QueryPostDO;
import com.chomolungma.system.post.repository.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class PostRepositoryImpl implements IPostRepository{

    @Autowired
    private PostMapper postMapper;

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
    public IPage<PostEntity> query(Page<?> page, PostEntity postEntity) {
        PostDO postDO = new PostDO();
        postDO.setName(postEntity.getName());
        postDO.setCode(postEntity.getCode());
        postDO.setType(postEntity.getType());
        postDO.setSort(postEntity.getSort());
        IPage<QueryPostDO> queryPostDOList = postMapper.selectPageList(page, postDO);
        return PostConverter.INSTANCE.toIPage(queryPostDOList);
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
