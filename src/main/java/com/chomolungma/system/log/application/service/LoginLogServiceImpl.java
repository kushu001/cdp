package com.chomolungma.system.log.application.service;

import com.chomolungma.common.tools.IpUtils;
import com.chomolungma.system.log.domain.repository.ILoginLogRepository;
import com.chomolungma.system.log.interfaces.dto.LoginLogDTO;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginLogServiceImpl implements LoginLogService{
    @Autowired
    private ILoginLogRepository iLoginLogRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public Void generateLoginLog(String username) {
        String agent = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(agent);
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        LoginLogDTO loginLogDTO = new LoginLogDTO();
        loginLogDTO.setUser(username);
        loginLogDTO.setIp(IpUtils.getIpAddress(request));
        loginLogDTO.setClient(browser.getName());
        iLoginLogRepository.save(loginLogDTO);
        return null;
    }
}
