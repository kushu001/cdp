package com.chomolungma.system.dict.domain.repository;

import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.interfaces.dto.DictItemPageDTO;

import java.util.List;

public interface IDictItemRepository {
    DictItemPageDTO query(int current, int size,Long dictId, String name, String code);

    DictItemEntity query(Long id);

    List<DictItemEntity> query(String code);

    void save(DictItemEntity dictItemEntity);

    void remove(List<Long>ids);
}
