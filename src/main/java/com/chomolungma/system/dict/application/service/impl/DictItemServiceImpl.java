package com.chomolungma.system.dict.application.service.impl;

import com.chomolungma.core.application.service.BaseService;
import com.chomolungma.system.dict.application.service.DictItemService;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.domain.repository.IDictItemRepository;
import com.chomolungma.system.dict.infrastructure.mybatis.repository.mapper.DictItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictItemServiceImpl extends BaseService implements DictItemService {
    @Autowired
    private DictItemMapper dictItemMapper;

    @Autowired
    private IDictItemRepository iDictItemRepository;

    @Override
    public Void createDictItem(DictItemEntity dictItemEntity) {
        iDictItemRepository.save(dictItemEntity);
        return null;
    }

    @Override
    public Void updateDictItem(DictItemEntity dictItemEntity) {
        iDictItemRepository.save(dictItemEntity);
        return null;
    }
}
