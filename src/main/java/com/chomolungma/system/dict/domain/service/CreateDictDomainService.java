package com.chomolungma.system.dict.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.domain.mapper.DictMapper;
import org.springframework.context.ApplicationContext;

public class CreateDictDomainService implements DomainService<Void> {
    private DictEntity dictEntity;
    public CreateDictDomainService(DictEntity dictEntity){
        this.dictEntity = dictEntity;
    }
    @Override
    public Void execute(ApplicationContext context) {
        context.getBean(DictMapper.class).insert(dictEntity);
        return null;
    }
}
