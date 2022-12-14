package com.chomolungma.system.log.infrastructure.mybatis.repository.mapper;

import com.chomolungma.system.log.infrastructure.dataobject.OperateLogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperateLogMapper {
    List<OperateLogDO> selectList(OperateLogDO operateLogDO);

    void insert(OperateLogDO operateLogDO);
}
