package com.chomolungma.system.dict.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.domain.mapper.DictItemMapper;
import org.springframework.context.ApplicationContext;

public class UpdateDictItemDomainService implements DomainService<Void> {
    private DictItemEntity dictItemEntity;
    public UpdateDictItemDomainService(DictItemEntity dictItemEntity){
        this.dictItemEntity = dictItemEntity;
    }
    @Override
    public Void execute(ApplicationContext context) {
        context.getBean(DictItemMapper.class).updateById(dictItemEntity);
        return null;
    }
}
