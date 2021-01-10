package com.chomolungma.dict.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.dict.mapper.DictMapper;
import com.chomolungma.dict.param.DictParam;
import com.chomolungma.dict.pojo.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/dict")
public class DictController{

    private DictMapper dictMapper;

    public DictController(DictMapper dictMapper){
        this.dictMapper = dictMapper;
    }

    @PostMapping
    public Result addDict(@RequestBody DictParam dictParam){
        Dict dict  = new Dict();
        dict.setName(dictParam.getName());
        dict.setCode(dictParam.getCode());
        dict.setSorter(dictParam.getSorter());
        dict.setDesc(dictParam.getDesc());
        dictMapper.insert(dict);

        return Result.success();
    }

    @PutMapping
    public Result updateDict(@RequestBody DictParam dictParam){
        Dict dict = new Dict();
        dict.setId(dictParam.getId());
        dict.setName(dictParam.getName());
        dict.setStatus(dictParam.getStatus());
        dict.setCode(dictParam.getCode());
        dict.setDesc(dictParam.getDesc());
        dictMapper.updateById(dict);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteDict(@PathVariable String ids){
        dictMapper.deleteBatchIds(Arrays.asList(ids.split(",").clone()));
        return Result.success();
    }
}
