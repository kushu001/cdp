package com.chomolungma.system.dict.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.domain.repository.IDictItemRepository;
import com.chomolungma.system.dict.infrastructure.converter.DictItemConverter;
import com.chomolungma.system.dict.infrastructure.dataobject.DictItemDO;
import com.chomolungma.system.dict.infrastructure.mybatis.repository.mapper.DictItemMapper;
import com.chomolungma.system.dict.interfaces.dto.DictItemPageDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class DictItemRepositoryImpl implements IDictItemRepository {
    @Autowired
    private DictItemMapper dictItemMapper;

    @Override
    public DictItemPageDTO query(int current, int size,Long dictId, String name, String code) {
        PageHelper.startPage(current, size);
        List<DictItemDO> dictItemDOS = dictItemMapper.selectList(new QueryWrapper<DictItemDO>().eq("dict_id", dictId).like(!StringUtils.isEmpty(name), "name", name).or().like(!StringUtils.isEmpty(code), "code", code));
        PageInfo<DictItemDO> pageInfo = new PageInfo<>(dictItemDOS);
        return DictItemConverter.INSTANCE.toDTO(pageInfo);
    }

    @Override
    public DictItemEntity query(Long id) {
        return DictItemConverter.INSTANCE.toEntity(dictItemMapper.selectById(id));
    }

    @Override
    public List<DictItemEntity> query(String code) {
        return DictItemConverter.INSTANCE.toEntity(dictItemMapper.selectListByDictCode(code));
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
