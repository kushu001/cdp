package com.chomolungma.system.dict.application.service;

import com.chomolungma.system.dict.domain.entity.DictEntity;

public interface DictService {
    Void createDict(DictEntity dictEntity);

    Void updateDict(DictEntity dictEntity);
}
