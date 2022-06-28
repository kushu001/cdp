package com.chomolungma.system.dict.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.dict.domain.mapper.DictItemMapper;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class RemoveDictItemDomainService implements DomainService<Void> {
    private List<String> ids;
    public RemoveDictItemDomainService(List<String> ids){
        this.ids = ids;
    }
    @Override
    public Void execute(ApplicationContext context) {
        context.getBean(DictItemMapper.class).deleteBatchIds(ids);
        return null;
    }
}
