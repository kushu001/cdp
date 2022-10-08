package com.chomolungma.system.post.interfaces.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.core.interfaces.dto.PageDTO;
import com.chomolungma.system.post.domain.repository.IPostRepository;
import com.chomolungma.system.post.interfaces.mapstruct.PostEntityMapStruct;
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
        return Result.success(iPostRepository.query(pageDTO.getPage(), pageDTO.getLimit(), name, code));
    }

    @PostMapping
    public Result createPost(@RequestBody PostParam postParam){
        iPostRepository.save(PostEntityMapStruct.INSTANCE.toEntity(postParam));
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getPost(@PathVariable("id") Long id){
        return Result.success(iPostRepository.query(id));
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
