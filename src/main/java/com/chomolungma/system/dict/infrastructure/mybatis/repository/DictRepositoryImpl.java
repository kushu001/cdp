package com.chomolungma.system.dict.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.domain.repository.IDictRepository;
import com.chomolungma.system.dict.infrastructure.converter.DictConverter;
import com.chomolungma.system.dict.infrastructure.dataobject.DictDO;
import com.chomolungma.system.dict.infrastructure.dataobject.DictItemDO;
import com.chomolungma.system.dict.infrastructure.mybatis.repository.mapper.DictItemMapper;
import com.chomolungma.system.dict.infrastructure.mybatis.repository.mapper.DictMapper;
import com.chomolungma.system.dict.interfaces.dto.DictPageDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DictRepositoryImpl implements IDictRepository {
    private final DictMapper dictMapper;

    private final DictItemMapper dictItemMapper;

    public DictRepositoryImpl(DictMapper dictMapper, DictItemMapper dictItemMapper) {
        this.dictMapper = dictMapper;
        this.dictItemMapper = dictItemMapper;
    }

    @Override
    public DictPageDTO query(int current, int size, String param) {
        PageHelper.startPage(current, size);
        List<DictDO> dictDOS = dictMapper.selectList(new QueryWrapper<DictDO>().like(param != null, "name", param).or().like(param != null, "code", param));
        PageInfo<DictDO> pageInfo = new PageInfo<>(dictDOS);
        return DictConverter.INSTANCE.toDTO(pageInfo);
    }

    @Override
    public DictEntity query(Long id) {
        return DictConverter.INSTANCE.toEntity(dictMapper.selectById(id));
    }

    @Override
    public void save(DictEntity dictEntity) {
        DictDO dictDO = DictConverter.INSTANCE.toDO(dictEntity);
        if (dictDO.getId() == null){
            dictMapper.insert(dictDO);
        }else{
            dictMapper.updateById(dictDO);
        }
    }

    @Override
    @Transactional
    public void remove(List<Long> ids) {
        dictMapper.deleteBatchIds(ids);
        dictItemMapper.delete(new QueryWrapper<DictItemDO>().in("dict_id", ids));
    }
}
