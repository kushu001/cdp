package com.chomolungma.system.post.interfaces.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.system.post.domain.entity.PostEntity;
import com.chomolungma.system.post.interfaces.mapstruct.PostEntityMapStruct;
import com.chomolungma.system.post.interfaces.param.PostPageParam;
import com.chomolungma.system.post.interfaces.param.PostParam;
import com.chomolungma.system.post.repository.IPostRepository;
import com.chomolungma.system.post.application.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private IPostRepository iPostRepository;

    @GetMapping
    public Result pageList(PostPageParam postPageParam){
        PostEntity postEntity = PostEntityMapStruct.INSTANCE.toEntity(postPageParam);
        IPage<PostEntity> postEntityPage = postService.pageList(new Page<>(postPageParam.getPage(), postPageParam.getLimit()), postEntity);
        return Result.success(PostEntityMapStruct.INSTANCE.toDTO(postEntityPage));
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
