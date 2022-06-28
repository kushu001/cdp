package com.chomolungma.system.dict.application.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.core.application.service.BaseService;
import com.chomolungma.system.dict.application.service.DictService;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.domain.service.CreateDictDomainService;
import com.chomolungma.system.dict.domain.service.GetDictDomainService;
import com.chomolungma.system.dict.domain.service.QueryPageDictDomainService;
import com.chomolungma.system.dict.domain.service.UpdateDictDomainService;
import org.springframework.stereotype.Service;

@Service
public class DictServiceImpl extends BaseService implements DictService {


    @Override
    public IPage<DictEntity> queryPageDict(Page<DictEntity> page, String param) {
        return execute(new QueryPageDictDomainService(page, param));
    }

    @Override
    public DictEntity getDict(Long id) {
        return execute(new GetDictDomainService(id));
    }

    @Override
    public Void createDict(DictEntity dictEntity) {
        execute(new CreateDictDomainService(dictEntity));
        return null;
    }

    @Override
    public Void updateDict(DictEntity dictEntity) {
        execute(new UpdateDictDomainService(dictEntity));
        return null;
    }
}
