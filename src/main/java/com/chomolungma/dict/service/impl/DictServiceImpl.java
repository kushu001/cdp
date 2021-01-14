package com.chomolungma.dict.service.impl;

import com.chomolungma.dict.mapper.DictMapper;
import com.chomolungma.dict.pojo.Dict;
import com.chomolungma.dict.pojo.DictItem;
import com.chomolungma.dict.service.DictService;
import com.chomolungma.dict.vo.DictVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictServiceImpl implements DictService {


    @Autowired
    private DictMapper dictMapper;

    @Override
    public List<DictVo> queryDictTree() {
        List<DictVo> dictVoList = new ArrayList<>();

        List<Dict> result = dictMapper.selectList(new Dict());
        for (Dict dict: result) {
            DictVo dictVo = new DictVo();
            dictVo.setId(dict.getId());
            dictVo.setName(dict.getName());
            dictVo.setTitle(dict.getName());
            dictVo.setCode(dict.getCode());
            dictVo.setKey(dict.getId());
            dictVo.setSorter(dict.getSorter());
            dictVo.setStatus(dict.getStatus());
            dictVo.setDesc(dict.getDesc());
            dictVo.setIsLeaf(false);

            List<DictVo> children = new ArrayList<>();
            for (DictItem dictItem: dict.getChildren()) {
                DictVo dictItemVo = new DictVo();
                dictItemVo.setId(dictItem.getId());
                dictItemVo.setName(dictItem.getName());
                dictItemVo.setTitle(dictItem.getName());
                dictItemVo.setCode(dictItem.getCode());
                dictItemVo.setKey(Long.valueOf(dictVo.getKey()+""+dictItem.getId()));
                dictItemVo.setSorter(dictItem.getSorter());
                dictItemVo.setStatus(dictItem.getStatus());
                dictItemVo.setDesc(dictItem.getDesc());
                DictVo copyVo = new DictVo();
                BeanUtils.copyProperties(dictVo,copyVo);
                dictItemVo.setParent(copyVo);
                dictItemVo.setIsLeaf(true);
                children.add(dictItemVo);
            }
            dictVo.setChildren(children);
            dictVoList.add(dictVo);
        }


        return dictVoList;
    }
}
