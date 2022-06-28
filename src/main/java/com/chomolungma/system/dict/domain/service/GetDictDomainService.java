package com.chomolungma.system.dict.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.domain.mapper.DictMapper;
import org.springframework.context.ApplicationContext;

public class GetDictDomainService implements DomainService<DictEntity> {
    private Long id;
    public GetDictDomainService(Long id){
        this.id = id;
    }
    @Override
    public DictEntity execute(ApplicationContext context) {
        return context.getBean(DictMapper.class).selectById(id);
    }
}
