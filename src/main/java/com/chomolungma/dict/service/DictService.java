package com.chomolungma.dict.service;

import com.chomolungma.dict.param.DictItemParam;
import com.chomolungma.dict.vo.DictVo;

import java.util.List;

public interface DictService {
    List<DictVo> queryDictTree();

    void createDictItem(DictItemParam dictItemParam);

    void updateDictItem(DictItemParam dictItemParam);

    void deleteDictItem(List<String> ids);

}
