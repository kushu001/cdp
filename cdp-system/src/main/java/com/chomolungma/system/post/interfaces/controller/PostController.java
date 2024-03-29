package com.chomolungma.system.post.interfaces.controller;


import com.chomolungma.system.post.interfaces.mapstruct.PostEntityMapStruct;
import com.chomolungma.core.dto.PageDTO;
import com.chomolungma.core.result.Result;
import com.chomolungma.system.post.domain.repository.IPostRepository;
import com.chomolungma.system.post.interfaces.param.PostParam;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final IPostRepository iPostRepository;

    public PostController(IPostRepository iPostRepository) {
        this.iPostRepository = iPostRepository;
    }

    @GetMapping
    public Result pageList(PageDTO pageDTO, @RequestParam(required = false) String name, @RequestParam(required = false) String code){
        return Result.success(iPostRepository.find(pageDTO.getPage(), pageDTO.getLimit(), name, code));
    }
    @GetMapping("/all")
    public Result list(){
        return Result.success(PostEntityMapStruct.INSTANCE.toDTO(iPostRepository.findAll()));
    }
    @PostMapping
    public Result createPost(@RequestBody PostParam postParam){
        iPostRepository.save(PostEntityMapStruct.INSTANCE.toEntity(postParam));
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getPost(@PathVariable("id") Long id){
        return Result.success(PostEntityMapStruct.INSTANCE.toDTO(iPostRepository.find(id)));
    }

    @PutMapping
    public Result updatePost(@RequestBody PostParam postParam){
        iPostRepository.save(PostEntityMapStruct.INSTANCE.toEntity(postParam));
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deletePosts(@PathVariable("ids") String ids){
        iPostRepository.remove(Arrays.asList(ids.split(",")));
        return Result.success();
    }
}
