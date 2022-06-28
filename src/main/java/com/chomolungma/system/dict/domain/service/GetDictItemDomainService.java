package com.chomolungma.system.dict.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.domain.mapper.DictItemMapper;
import org.springframework.context.ApplicationContext;

public class GetDictItemDomainService implements DomainService<DictItemEntity> {
    private Long dictId;
    private Long id;
    public GetDictItemDomainService(Long dictId, Long id){
        this.dictId = dictId;
        this.id = id;
    }
    @Override
    public DictItemEntity execute(ApplicationContext context) {
        return context.getBean(DictItemMapper.class).selectOne(new QueryWrapper<DictItemEntity>().eq("dict_id",dictId).eq("id", id));
    }
}
