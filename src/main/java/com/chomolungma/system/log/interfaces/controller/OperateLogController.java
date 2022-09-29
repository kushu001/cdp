package com.chomolungma.system.log.interfaces.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.core.interfaces.dto.PageDTO;
import com.chomolungma.system.log.domain.repository.IOperateLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/operate-log")
public class OperateLogController {
    @Autowired
    private IOperateLogRepository iOperateLogRepository;
    @GetMapping
    public Result pageList(PageDTO pageDTO,
                           @RequestParam(required = false) String user,
                           @RequestParam(required = false) String requestMethod,
                           @RequestParam(required = false) String resourceName){
        return Result.success(iOperateLogRepository.find(pageDTO.getPage(), pageDTO.getLimit(), user, requestMethod, resourceName));
    }
}
