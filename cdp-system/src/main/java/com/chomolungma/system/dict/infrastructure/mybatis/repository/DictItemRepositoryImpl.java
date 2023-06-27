package com.chomolungma.system.dict.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.dict.infrastructure.converter.DictItemConverter;
import com.chomolungma.system.dict.infrastructure.dataobject.DictItemDO;
import com.chomolungma.system.dict.infrastructure.mybatis.repository.mapper.DictItemMapper;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.domain.repository.IDictItemRepository;
import com.chomolungma.system.dict.interfaces.assembler.DictItemAssembler;
import com.chomolungma.system.dict.interfaces.dto.DictItemDTO;
import com.chomolungma.system.dict.interfaces.dto.DictItemPageDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class DictItemRepositoryImpl implements IDictItemRepository {
    private final DictItemMapper dictItemMapper;

    public DictItemRepositoryImpl(DictItemMapper dictItemMapper) {
        this.dictItemMapper = dictItemMapper;
    }

    @Override
    public DictItemPageDTO find(int current, int size,Long dictId, String name, String code) {
        PageHelper.startPage(current, size);
        List<DictItemDO> dictItemDOS = dictItemMapper.selectList(new QueryWrapper<DictItemDO>().eq("dict_id", dictId).and(!StringUtils.isEmpty(name),wrapper -> {
            wrapper.like( "name", name);
        }).and(!StringUtils.isEmpty(code), wrapper -> {
            wrapper.like("code", code);
        }));
        PageInfo<DictItemDO> pageInfo = new PageInfo<>(dictItemDOS);
        return DictItemAssembler.toDTO(pageInfo);
    }

    @Override
    public DictItemEntity find(Long id) {
        return DictItemConverter.INSTANCE.toEntity(dictItemMapper.selectById(id));
    }

    @Override
    public List<DictItemDTO> find(String code) {
        return DictItemAssembler.toDTO(dictItemMapper.selectListByDictCode(code));
    }

    @Override
    public void save(DictItemEntity dictItemEntity) {
        DictItemDO dictItemDO = DictItemConverter.INSTANCE.toDO(dictItemEntity);
        if (dictItemDO.getId() == null){
            dictItemMapper.insert(dictItemDO);
        }else{
            dictItemMapper.updateById(dictItemDO);
        }
    }

    @Override
    public void remove(List<Long> ids) {
        dictItemMapper.deleteBatchIds(ids);
    }
}
