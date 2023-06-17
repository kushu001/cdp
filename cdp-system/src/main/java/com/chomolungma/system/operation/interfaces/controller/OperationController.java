package com.chomolungma.system.operation.interfaces.controller;

import com.chomolungma.system.operation.application.service.OperationService;
import com.chomolungma.system.operation.domain.assembler.OperationAssembler;
import com.chomolungma.system.operation.domain.entity.Operation;
import com.chomolungma.system.operation.domain.repository.IOperationRepository;
import com.chomolungma.system.operation.infrastructure.dataobject.OperationDO;
import com.chomolungma.system.operation.interfaces.param.OperationDTO;
import com.chomolungma.core.dto.PageDTO;
import com.chomolungma.core.result.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

/**
*  Automatically generated code by CDP-GENERATOR maven-plugin.
*  Thank you for your use.
*  Good Luck!
*/

@RestController
@RequestMapping("/api/v1/operation")
public class OperationController {
    private final IOperationRepository iOperationRepository;
    private final OperationService operationService;

    public OperationController(IOperationRepository iOperationRepository, OperationService operationService){
        this.iOperationRepository = iOperationRepository;
        this.operationService = operationService;
    }

    @GetMapping
    public Result pageList(PageDTO pageDTO,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String path,
            @RequestParam(required = false) String group,
            @RequestParam(required = false) String level
    ){
        Operation operation = new Operation();
        // 按钮名称
        operation.setName(name);
        // 编码
        operation.setCode(code);
        // 组件路径
        operation.setPath(path);
        // 所属分组
        operation.setGroup(group);
        // 级别（1. 系统级 2. 页面级）
        operation.setLevel(level);
        PageInfo<OperationDO> pageInfo = iOperationRepository.findPageList(operation, pageDTO.getPage(), pageDTO.getLimit());
        return Result.success(OperationAssembler.toOperationPageDTO(pageInfo));
    }

    @GetMapping("/{id}")
    public Result getOperation(@PathVariable("id") Long id){
        return Result.success(OperationAssembler.toDTO(iOperationRepository.find(id)));
    }


    @PostMapping
    public Result createOperation(@RequestBody OperationDTO operationDTO){
        iOperationRepository.save(OperationAssembler.toEntity(operationDTO));
        return Result.success();
    }

    @PutMapping
    public Result modifyOperation(@RequestBody OperationDTO operationDTO){
        iOperationRepository.save(OperationAssembler.toEntity(operationDTO));
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteOperation(@PathVariable String ids){
        iOperationRepository.remove(Arrays.asList(ids.split(",")));
        return Result.success();
    }
}