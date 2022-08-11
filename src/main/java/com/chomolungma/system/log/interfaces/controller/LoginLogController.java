package com.chomolungma.system.log.interfaces.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.system.log.domain.repository.ILoginLogRepository;
import com.chomolungma.system.log.interfaces.dto.LoginLogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login-log")
public class LoginLogController {
    @Autowired
    private ILoginLogRepository iLoginLogRepository;

    @GetMapping
    public Result pageList(LoginLogDTO loginLogDTO){
        return Result.success(iLoginLogRepository.find(loginLogDTO));
    }
}
