package com.chomolungma.system.log.interfaces.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.core.interfaces.dto.PageDTO;
import com.chomolungma.system.log.domain.repository.ILoginLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login-log")
public class LoginLogController {
    @Autowired
    private ILoginLogRepository iLoginLogRepository;

    @GetMapping
    public Result pageList(PageDTO pageDTO,
                           @RequestParam(required = false) String user,
                           @RequestParam(required = false) String client,
                           @RequestParam(required = false) String os){
        return Result.success(iLoginLogRepository.find(pageDTO.getPage(), pageDTO.getLimit(), user, client, os));
    }
}
