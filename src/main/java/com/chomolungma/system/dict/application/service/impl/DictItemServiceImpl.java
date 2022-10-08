package com.chomolungma.system.dict.application.service.impl;

import com.chomolungma.core.application.service.BaseService;
import com.chomolungma.system.dict.application.service.DictItemService;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.domain.repository.IDictItemRepository;
import org.springframework.stereotype.Service;

@Service
public class DictItemServiceImpl extends BaseService implements DictItemService {

    private final IDictItemRepository iDictItemRepository;

    public DictItemServiceImpl(IDictItemRepository iDictItemRepository) {
        this.iDictItemRepository = iDictItemRepository;
    }

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
