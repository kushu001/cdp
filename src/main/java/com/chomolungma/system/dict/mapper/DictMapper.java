package com.chomolungma.system.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.dict.pojo.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictMapper extends BaseMapper<Dict> {
    List<Dict> selectList(@Param("dict") Dict dict);
}
