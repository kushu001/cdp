package com.chomolungma.dict.service;

import com.chomolungma.dict.pojo.Dict;
import com.chomolungma.dict.vo.DictVo;

import java.util.List;

public interface DictService {
    List<DictVo> queryDictTree();

}
