package com.chomolungma.system.dict.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.domain.mapper.DictItemMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

public class QueryPageDictItemDomainService implements DomainService<IPage<DictItemEntity>> {
    private Long dictId;
    private IPage<DictItemEntity> page;
    private DictItemEntity dictItemEntity;

    public QueryPageDictItemDomainService(Long dictId, IPage<DictItemEntity> page, DictItemEntity dictItemEntity){
        this.dictId = dictId;
        this.page = page;
        this.dictItemEntity = dictItemEntity;
    }

    @Override
    public IPage<DictItemEntity> execute(ApplicationContext context) {
        return context.getBean(DictItemMapper.class).selectPage(page, new QueryWrapper<DictItemEntity>().eq("dict_id", dictId).like(!StringUtils.isEmpty(dictItemEntity.getName()), "name", dictItemEntity.getName()).like(!StringUtils.isEmpty(dictItemEntity.getCode()), "code", dictItemEntity.getCode()));
    }
}
