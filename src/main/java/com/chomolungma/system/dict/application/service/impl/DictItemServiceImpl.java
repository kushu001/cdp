package com.chomolungma.system.dict.application.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.core.application.service.BaseService;
import com.chomolungma.system.dict.application.service.DictItemService;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.domain.mapper.DictItemMapper;
import com.chomolungma.system.dict.domain.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictItemServiceImpl extends BaseService implements DictItemService {
    @Autowired
    private DictItemMapper dictItemMapper;
    @Override
    public IPage<DictItemEntity> queryPageDict(Long dictId, Page<DictItemEntity> page, DictItemEntity dictItem) {
        return execute(new QueryPageDictItemDomainService(dictId, page, dictItem));
    }

    @Override
    public DictItemEntity getDictItem(Long dictId, Long id) {
        return execute(new GetDictItemDomainService(dictId, id));
    }

    @Override
    public Void createDictItem(DictItemEntity dictItemEntity) {
        return execute(new CreateDictItemDomainService(dictItemEntity));
    }

    @Override
    public Void updateDictItem(DictItemEntity dictItemEntity) {
        return execute(new UpdateDictItemDomainService(dictItemEntity));
    }

    @Override
    public Void deleteDictItem(List<String> ids) {
        return execute(new RemoveDictItemDomainService(ids));
    }

    @Override
    public List<DictItemEntity> getDictItems(String dictCode) {
        return dictItemMapper.selectListByDictCode(dictCode);
    }
}
