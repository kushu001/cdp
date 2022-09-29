package com.chomolungma.system.dict.application.service;

import com.chomolungma.system.dict.domain.entity.DictItemEntity;

public interface DictItemService {

    Void createDictItem(DictItemEntity dictItemEntity);

    Void updateDictItem(DictItemEntity dictItemEntity);
}
