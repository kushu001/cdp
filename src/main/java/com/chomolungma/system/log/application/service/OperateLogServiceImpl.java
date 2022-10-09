package com.chomolungma.system.log.application.service;

import com.chomolungma.core.CurrentProfileHolder;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import com.chomolungma.system.log.domain.repository.IOperateLogRepository;
import com.chomolungma.system.log.interfaces.dto.OperateLogDTO;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@Service
public class OperateLogServiceImpl implements OperateLogService{
    Log logger = LogFactory.getLog(OperateLogServiceImpl.class);
    private final IOperateLogRepository iOperateLogRepository;

    private final HttpServletRequest request;

    public OperateLogServiceImpl(IOperateLogRepository iOperateLogRepository, HttpServletRequest request) {
        this.iOperateLogRepository = iOperateLogRepository;
        this.request = request;
    }

    @Override
    public Void generateOperateLog() throws IOException {
        AccountDTO accountDTO = CurrentProfileHolder.getProfile();
        OperateLogDTO operateLogDTO = new OperateLogDTO();
        operateLogDTO.setUser(accountDTO.getUsername());
        operateLogDTO.setUrl(request.getRequestURL().substring(0, request.getRequestURL().length()- request.getRequestURI().length()));
        operateLogDTO.setResourceName(request.getRequestURI());
        operateLogDTO.setPathPayload(request.getQueryString());
        if (!request.getRequestURI().contains("/import")){
            operateLogDTO.setPayload(charReader(request));
        }
        operateLogDTO.setRequestMethod(request.getMethod());
        iOperateLogRepository.save(operateLogDTO);
        return null;
    }

    private String charReader(HttpServletRequest request) throws IOException {
        BufferedReader br = request.getReader();
        String str, wholeStr = "";
        while ((str = br.readLine()) != null) {
            wholeStr += str;
        }
        return wholeStr;
    }
}
