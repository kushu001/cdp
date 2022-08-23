package com.chomolungma.system.dict.interfaces.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.system.dict.application.service.DictItemService;
import com.chomolungma.system.dict.domain.entity.DictItemEntity;
import com.chomolungma.system.dict.interfaces.assembler.DictItemAssembler;
import com.chomolungma.system.dict.interfaces.param.DictItemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/dict/item")
public class DictItemController {
    @Autowired
    private DictItemService dictItemService;

    @GetMapping("/{dictId}")
    public Result pageList(@PathVariable("dictId") Long dictId, DictItemParam dictItemParam){
        return Result.success(DictItemAssembler.covertToDTO(dictItemService.queryPageDict(dictId, new Page<DictItemEntity>(dictItemParam.getPage(),dictItemParam.getLimit()), DictItemAssembler.covertToEntity(dictItemParam))));
    }

    @GetMapping("/{dictId}/{id}")
    public Result info(@PathVariable("dictId") Long dictId, @PathVariable("id") Long id){
        return Result.success(DictItemAssembler.covertToDTO(dictItemService.getDictItem(dictId, id)));
    }

    @PostMapping("/{dictId}")
    public Result create(@PathVariable("dictId") Long dictId, @RequestBody DictItemParam dictItemParam){
        dictItemParam.setDictId(dictId);
        return Result.success(dictItemService.createDictItem(DictItemAssembler.covertToEntity(dictItemParam)));
    }

    @PutMapping("/{dictId}")
    public Result update(@PathVariable("dictId") Long dictId, @RequestBody DictItemParam dictItemParam){
        dictItemParam.setDictId(dictId);
        return Result.success(dictItemService.updateDictItem(DictItemAssembler.covertToEntity(dictItemParam)));
    }

    @DeleteMapping("/{dictId}/{ids}")
    public Result delete(@PathVariable("dictId") Long dictId, @PathVariable("ids") String ids){
        dictItemService.deleteDictItem(Arrays.asList(ids.split(",")));
        return Result.success();
    }
    @GetMapping("/dict/{dictCode}")
    public Result getItems(@PathVariable("dictCode") String dictCode){
        return Result.success(DictItemAssembler.covertToDTO(dictItemService.getDictItems(dictCode)));
    }
}
