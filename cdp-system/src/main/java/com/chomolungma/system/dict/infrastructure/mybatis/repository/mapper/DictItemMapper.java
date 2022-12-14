package com.chomolungma.system.dict.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.dict.infrastructure.dataobject.DictItemDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DictItemMapper extends BaseMapper<DictItemDO> {
    List<DictItemDO> selectListByDictCode(String code);
}
