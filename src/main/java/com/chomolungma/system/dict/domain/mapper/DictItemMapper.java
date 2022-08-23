package com.chomolungma.system.dict.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DictItemMapper extends BaseMapper<DictItemEntity> {
    List<DictItemEntity> selectListByDictCode(String code);
}
