package com.chomolungma.system.log.infrastructure.mybatis.repository.mapper;

import com.chomolungma.system.log.infrastructure.dataobject.LoginLogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginLogMapper {
    List<LoginLogDO> selectList(LoginLogDO loginLogDO);

    void insert(LoginLogDO loginLogDO);
}
