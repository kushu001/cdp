package com.chomolungma.system.dict.application.service.impl;

import com.chomolungma.system.dict.application.service.DictService;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.domain.repository.IDictRepository;
import org.springframework.stereotype.Service;

@Service
public class DictServiceImpl implements DictService {

    private final IDictRepository iDictRepository;

    public DictServiceImpl(IDictRepository iDictRepository) {
        this.iDictRepository = iDictRepository;
    }

    @Override
    public Void createDict(DictEntity dictEntity) {
        iDictRepository.save(dictEntity);
        return null;
    }

    @Override
    public Void updateDict(DictEntity dictEntity) {
        iDictRepository.save(dictEntity);
        return null;
    }
}
