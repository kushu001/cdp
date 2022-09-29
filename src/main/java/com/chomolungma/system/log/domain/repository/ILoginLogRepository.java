package com.chomolungma.system.log.domain.repository;

import com.chomolungma.system.log.interfaces.dto.LoginLogDTO;
import com.chomolungma.system.log.interfaces.dto.LoginLogPageDTO;

public interface ILoginLogRepository {
    LoginLogPageDTO find(int current, int size, String user, String client, String os);

    Void save(LoginLogDTO loginLogDTO);
}
