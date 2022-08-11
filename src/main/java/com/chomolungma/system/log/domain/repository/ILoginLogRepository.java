package com.chomolungma.system.log.domain.repository;

import com.chomolungma.system.log.interfaces.dto.LoginLogDTO;
import com.chomolungma.system.log.interfaces.dto.LoginLogPageDTO;

public interface ILoginLogRepository {
    LoginLogPageDTO find(LoginLogDTO loginLogDTO);

    Void save(LoginLogDTO loginLogDTO);
}
