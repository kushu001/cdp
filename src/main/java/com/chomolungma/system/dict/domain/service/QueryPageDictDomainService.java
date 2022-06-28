package com.chomolungma.system.dict.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.domain.mapper.DictMapper;
import org.springframework.context.ApplicationContext;

public class QueryPageDictDomainService implements DomainService<IPage<DictEntity>> {
    private String param;
    private Page<DictEntity> page;

    public QueryPageDictDomainService(Page<DictEntity> page, String param){
        this.page = page;
        this.param = param;
    }

    @Override
    public IPage<DictEntity> execute(ApplicationContext context) {
        IPage<DictEntity> pages  = context.getBean(DictMapper.class).selectPage(page, new QueryWrapper<DictEntity>().like(param != null, "name", param).or().like(param != null, "code", param));
        return pages;
    }
}
