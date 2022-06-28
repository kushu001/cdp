package com.chomolungma.system.dict.application.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.dict.domain.entity.DictEntity;

public interface DictService {
    IPage<DictEntity> queryPageDict(Page<DictEntity> page, String param);

    DictEntity getDict(Long id);

    Void createDict(DictEntity dictEntity);

    Void updateDict(DictEntity dictEntity);
}
