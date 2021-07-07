package com.chomolungma.system.dict.service;

import com.chomolungma.system.dict.param.DictItemParam;
import com.chomolungma.system.dict.vo.DictVo;

import java.util.List;

public interface DictService {
    List<DictVo> queryDictTree();

    void createDictItem(DictItemParam dictItemParam);

    void updateDictItem(DictItemParam dictItemParam);

    void deleteDictItem(List<String> ids);

}
