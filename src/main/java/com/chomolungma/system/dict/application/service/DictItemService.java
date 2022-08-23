package com.chomolungma.system.dict.application.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;

import java.util.List;

public interface DictItemService {
    IPage<DictItemEntity> queryPageDict(Long dictId, Page<DictItemEntity> page, DictItemEntity dictItem);

    DictItemEntity getDictItem(Long dictId, Long id);

    Void createDictItem(DictItemEntity dictItemEntity);

    Void updateDictItem(DictItemEntity dictItemEntity);

    Void deleteDictItem(List<String> ids);

    List<DictItemEntity> getDictItems(String dictCode);
}
