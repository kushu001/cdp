package com.chomolungma.system.log.interfaces.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.system.log.domain.repository.IOperateLogRepository;
import com.chomolungma.system.log.interfaces.dto.OperateLogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/operate-log")
public class OperateLogController {
    @Autowired
    private IOperateLogRepository iOperateLogRepository;
    @GetMapping
    public Result pageList(OperateLogDTO operateLogDTO){
        return Result.success(iOperateLogRepository.find(operateLogDTO));
    }
}
