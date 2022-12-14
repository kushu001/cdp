package com.chomolungma.system.dict.domain.repository;

import com.chomolungma.system.dict.interfaces.dto.DictPageDTO;
import com.chomolungma.system.dict.domain.entity.DictEntity;

import java.util.List;

public interface IDictRepository {
    DictPageDTO find(int current, int size, String param);

    DictEntity find(Long id);

    void save(DictEntity dictEntity);

    void remove(List<Long>ids);
}
