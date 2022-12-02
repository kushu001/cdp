package com.chomolungma.system.dict.interfaces.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.core.interfaces.dto.PageDTO;
import com.chomolungma.system.dict.application.service.DictService;
import com.chomolungma.system.dict.domain.entity.DictEntity;
import com.chomolungma.system.dict.domain.repository.IDictRepository;
import com.chomolungma.system.dict.interfaces.assembler.DictAssembler;
import com.chomolungma.system.dict.interfaces.param.DictParam;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/dict")
public class DictController{


    private final DictService dictService;

    private final IDictRepository iDictRepository;

    public DictController(DictService dictService, IDictRepository iDictRepository){
        this.dictService = dictService;
        this.iDictRepository = iDictRepository;
    }

    @GetMapping
    public Result pageList(PageDTO pageDTO, @RequestParam(required = false) String param){
        return Result.success(iDictRepository.query(pageDTO.getPage(), pageDTO.getLimit(), param));
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAuthority('system:dict:get')")
    public Result info(@PathVariable("id") Long id){
        return Result.success(DictAssembler.toDTO(iDictRepository.find(id)));
    }

    @PostMapping
    //@PreAuthorize("hasAuthority('system:dict:add')")
    public Result createDict(@RequestBody DictParam dictParam){
        dictService.createDict(DictAssembler.covertToEntity(dictParam));
        return Result.success();
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasAuthority('system:dict:edit')")
    public Result updateDict(@PathVariable("id") Long id, @RequestBody DictParam dictParam){
        DictEntity dictEntity = DictAssembler.covertToEntity(dictParam);
        dictEntity.setId(id);
        return Result.success(dictService.updateDict(dictEntity));
    }

    @DeleteMapping("/{ids}")
    //@PreAuthorize("hasAuthority('system:dict:delete')")
    public Result deleteDict(@PathVariable String ids){
        iDictRepository.remove(Arrays.stream(ids.split(",")).map(Long::valueOf).collect(Collectors.toList()));
        return Result.success();
    }
}
