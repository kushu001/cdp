package com.chomolungma.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.dict.pojo.DictItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictItemMapper extends BaseMapper<DictItem> {
}
