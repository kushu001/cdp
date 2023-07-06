package com.chomolungma.system.resource.interfaces.controller;

import com.chomolungma.core.dto.PageDTO;
import com.chomolungma.core.result.Result;
import com.chomolungma.system.resource.application.ResourceService;
import com.chomolungma.system.resource.domain.repository.IResourceRepository;
import com.chomolungma.system.resource.interfaces.assembler.ResourceAssembler;
import com.chomolungma.system.resource.interfaces.param.ResourceParam;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/resource")
public class ResourceController {

    private IResourceRepository iResourceRepository;

    private ResourceService resourceService;

    public ResourceController(IResourceRepository iResourceRepository, ResourceService resourceService){
        this.iResourceRepository = iResourceRepository;
        this.resourceService = resourceService;
    }
    @GetMapping
    public Result pageList(PageDTO pageDTO,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String sign,
                           @RequestParam(required = false) String url,
                           @RequestParam(required = false) String method
                           ){
        return Result.success(iResourceRepository.find(pageDTO.getPage(), pageDTO.getLimit(), name, sign, url, method));
    }

    @GetMapping("/{id}")
    public Result getResource(@PathVariable Long id){
        return Result.success(ResourceAssembler.toDTO(iResourceRepository.find(id)));
    }

    @PostMapping
    public Result create(@RequestBody ResourceParam resourceParam){
        resourceService.create(ResourceAssembler.toEntity(resourceParam));
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ResourceParam resourceParam){
        resourceService.modify(ResourceAssembler.toEntity(resourceParam));
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteResources(@PathVariable String ids){
        iResourceRepository.remove(Arrays.asList(ids.split(",")));
        return Result.success();
    }
}
