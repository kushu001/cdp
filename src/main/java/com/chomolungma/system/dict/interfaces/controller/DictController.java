package com.chomolungma.system.dict.interfaces.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.core.interfaces.dto.PageDTO;
import com.chomolungma.system.dict.application.service.DictService;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.domain.repository.IDictRepository;
import com.chomolungma.system.dict.infrastructure.mybatis.repository.mapper.DictMapper;
import com.chomolungma.system.dict.interfaces.assembler.DictAssembler;
import com.chomolungma.system.dict.interfaces.param.DictParam;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dict")
public class DictController{

    private DictMapper dictMapper;

    private DictService dictService;

    private IDictRepository iDictRepository;

    public DictController(DictMapper dictMapper,DictService dictService, IDictRepository iDictRepository){
        this.dictMapper = dictMapper;
        this.dictService = dictService;
        this.iDictRepository = iDictRepository;
    }

    @GetMapping
    public Result pageList(PageDTO pageDTO, @RequestParam(required = false) String param){
        return Result.success(iDictRepository.query(pageDTO.getPage(), pageDTO.getLimit(), param));
    }

    @GetMapping("/{id}")
    public Result info(@PathVariable("id") Long id){
        return Result.success(iDictRepository.query(id));
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
        iDictRepository.remove(Arrays.stream(ids.split(",")).map(Long::valueOf).collect(Collectors.toList()));
        return Result.success();
    }
}
