package com.chomolungma.system.dict.domain.repository;

import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.interfaces.dto.DictPageDTO;

import java.util.List;

public interface IDictRepository {
    DictPageDTO query(int current, int size, String param);

    DictEntity query(Long id);

    void save(DictEntity dictEntity);

    void remove(List<Long>ids);
}
