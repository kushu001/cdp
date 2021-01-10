package com.chomolungma.dict.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.dict.pojo.Dict;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface DictMapper extends BaseMapper<Dict> {
    IPage<Dict> selectPageVo(Page<?> page, @Param("dict") Dict dict);
}
