package com.chomolungma.system.dict.domain.repository;

import com.chomolungma.system.dict.interfaces.dto.DictItemDTO;
import com.chomolungma.system.dict.interfaces.dto.DictItemPageDTO;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;

import java.util.List;

public interface IDictItemRepository {
    DictItemPageDTO find(int current, int size, Long dictId, String name, String code);

    DictItemEntity find(Long id);

    List<DictItemDTO> find(String code);

    void save(DictItemEntity dictItemEntity);

    void remove(List<Long>ids);
}
