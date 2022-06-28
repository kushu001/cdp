package com.chomolungma.system.dict.interfaces.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.system.dict.application.service.DictService;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.domain.mapper.DictMapper;
import com.chomolungma.system.dict.interfaces.assembler.DictAssembler;
import com.chomolungma.system.dict.interfaces.param.DictItemParam;
import com.chomolungma.system.dict.interfaces.param.DictParam;
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


//    @GetMapping
//    public Result queryDict(){
//        return Result.success(dictService.queryDictTree());
//    }

    @GetMapping
    public Result pageList(DictParam dictParam){
        IPage<DictEntity> pages = dictService.queryPageDict(new Page<>(dictParam.getPage(),dictParam.getLimit()),dictParam.getParam());
        return Result.success(DictAssembler.covertToDTO(pages));
    }

    @GetMapping("/{id}")
    public Result info(@PathVariable("id") Long id){
        return Result.success(DictAssembler.covertToDictDTO(dictService.getDict(id)));
    }

    @PostMapping
    public Result createDict(@RequestBody DictParam dictParam){
        dictService.createDict(DictAssembler.covertToEntity(dictParam));
        return Result.success();
    }

    @PutMapping("/{id}")
    public Result updateDict(@PathVariable("id") Long id, @RequestBody DictParam dictParam){
        DictEntity dictEntity = DictAssembler.covertToEntity(dictParam);
        dictEntity.setId(id);
        return Result.success(dictService.updateDict(dictEntity));
    }

    @DeleteMapping("/{ids}")
    public Result deleteDict(@PathVariable String ids){
        dictMapper.deleteBatchIds(Arrays.asList(ids.split(",").clone()));
        return Result.success();
    }


    @PostMapping("/item")
    public Result createDictItem(@RequestBody DictItemParam dictItemParam){
        //dictService.createDictItem(dictItemParam);
        return Result.success();
    }


    @PutMapping("/item")
    public Result updateDictItem(@RequestBody DictItemParam dictItemParam){
        //dictService.updateDictItem(dictItemParam);
        return Result.success();
    }


    @DeleteMapping("/item/{ids}")
    public Result deleteDictItem(@PathVariable String ids){
        //dictService.deleteDictItem(Arrays.asList(ids.split(",").clone()));
        return Result.success();
    }
}
