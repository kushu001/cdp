package com.chomolungma.system.log.domain.repository;

import com.chomolungma.system.log.interfaces.dto.OperateLogDTO;
import com.chomolungma.system.log.interfaces.dto.OperateLogPageDTO;

public interface IOperateLogRepository {
    OperateLogPageDTO find(int current, int size, String user, String requestMethod, String resourceName);

    Void save(OperateLogDTO operateLogDTO);
}
