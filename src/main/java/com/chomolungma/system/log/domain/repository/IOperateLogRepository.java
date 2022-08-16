package com.chomolungma.system.log.domain.repository;

import com.chomolungma.system.log.interfaces.dto.OperateLogDTO;
import com.chomolungma.system.log.interfaces.dto.OperateLogPageDTO;

public interface IOperateLogRepository {
    OperateLogPageDTO find(OperateLogDTO operateLogDTO);

    Void save(OperateLogDTO operateLogDTO);
}
