package com.chomolungma.system.dict.interfaces.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.core.interfaces.dto.PageDTO;
import com.chomolungma.system.dict.application.service.DictItemService;
import com.chomolungma.system.dict.domain.repository.IDictItemRepository;
import com.chomolungma.system.dict.interfaces.assembler.DictItemAssembler;
import com.chomolungma.system.dict.interfaces.param.DictItemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dict/item")
public class DictItemController {
    @Autowired
    private DictItemService dictItemService;

    @Autowired
    private IDictItemRepository iDictItemRepository;

    @GetMapping("/{dictId}")
    public Result pageList(@PathVariable("dictId") Long dictId, PageDTO pageDTO, @RequestParam(required = false) String name, @RequestParam(required = false) String code){
        return Result.success(iDictItemRepository.query(pageDTO.getPage(), pageDTO.getLimit(), dictId, name, code));
    }

    @GetMapping("/{dictId}/{id}")
    public Result info(@PathVariable("dictId") Long dictId, @PathVariable("id") Long id){
        return Result.success(iDictItemRepository.query(id));
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
        //dictItemService.deleteDictItem(Arrays.asList(ids.split(",")));
        iDictItemRepository.remove(Arrays.stream(ids.split(",")).map(Long::valueOf).collect(Collectors.toList()));
        return Result.success();
    }
    @GetMapping("/dict/{dictCode}")
    public Result getItems(@PathVariable("dictCode") String dictCode){
        return Result.success(iDictItemRepository.query(dictCode));
    }
}
