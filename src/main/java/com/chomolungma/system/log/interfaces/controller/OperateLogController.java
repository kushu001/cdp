package com.chomolungma.system.log.interfaces.controller;

import com.chomolungma.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/operate-log")
public class OperateLogController {
    @GetMapping
    public Result pageList(){
        return Result.success();
    }
}
