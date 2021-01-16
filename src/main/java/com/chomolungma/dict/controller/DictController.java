package com.chomolungma.dict.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.dict.mapper.DictMapper;
import com.chomolungma.dict.param.DictItemParam;
import com.chomolungma.dict.param.DictParam;
import com.chomolungma.dict.pojo.Dict;
import com.chomolungma.dict.service.DictService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/dict")
public class DictController{

    private DictMapper dictMapper;

    private DictService dictService;

    public DictController(DictMapper dictMapper,DictService dictService){
        this.dictMapper = dictMapper;
        this.dictService = dictService;
    }


    @GetMapping
    public Result queryDict(){
        return Result.success(dictService.queryDictTree());
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


    @PostMapping("/item")
    public Result createDictItem(@RequestBody DictItemParam dictItemParam){
        dictService.createDictItem(dictItemParam);
        return Result.success();
    }


    @PutMapping("/item")
    public Result updateDictItem(@RequestBody DictItemParam dictItemParam){
        dictService.updateDictItem(dictItemParam);
        return Result.success();
    }


    @DeleteMapping("/item/{ids}")
    public Result deleteDictItem(@PathVariable String ids){
        dictService.deleteDictItem(Arrays.asList(ids.split(",").clone()));
        return Result.success();
    }
}
