package com.chomolungma.system.log.application.service;

import com.chomolungma.core.CurrentProfileHolder;
import com.chomolungma.system.account.entity.AccountEntity;
import com.chomolungma.system.log.domain.repository.IOperateLogRepository;
import com.chomolungma.system.log.interfaces.dto.OperateLogDTO;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

@Service
public class OperateLogServiceImpl implements OperateLogService{
    Log logger = LogFactory.getLog(OperateLogServiceImpl.class);
    @Autowired
    private IOperateLogRepository iOperateLogRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public Void generateOperateLog() throws IOException {
        AccountEntity accountEntity = CurrentProfileHolder.getProfile();
        OperateLogDTO operateLogDTO = new OperateLogDTO();
        operateLogDTO.setUser(accountEntity.getUsername());
        operateLogDTO.setUrl(request.getRequestURL().substring(0, request.getRequestURL().length()- request.getRequestURI().length()));
        operateLogDTO.setResourceName(request.getRequestURI());
        operateLogDTO.setPathPayload(request.getQueryString());
        operateLogDTO.setPayload(charReader(request));
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