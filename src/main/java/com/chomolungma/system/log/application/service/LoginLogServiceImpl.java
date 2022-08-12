package com.chomolungma.system.log.application.service;

import com.alibaba.fastjson.JSONObject;
import com.chomolungma.common.tools.AddressUtils;
import com.chomolungma.common.tools.IpUtils;
import com.chomolungma.system.log.domain.repository.ILoginLogRepository;
import com.chomolungma.system.log.interfaces.dto.LoginLogDTO;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginLogServiceImpl implements LoginLogService{
    Log logger = LogFactory.getLog(LoginLogServiceImpl.class);
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
        String ip = IpUtils.getIpAddress(request);
        LoginLogDTO loginLogDTO = new LoginLogDTO();
        loginLogDTO.setUser(username);
        loginLogDTO.setIp(ip);
        loginLogDTO.setClient(browser.getName());
        loginLogDTO.setOs(operatingSystem.getName());
        JSONObject address = AddressUtils.getCity(ip);
        logger.debug("=============" + address.get("region")+ ":" + address.get("city"));
        loginLogDTO.setAddress(address.get("region")+ " " + address.get("city"));
        iLoginLogRepository.save(loginLogDTO);
        return null;
    }
}
