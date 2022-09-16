package com.chomolungma.system.user.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.user.domain.repository.dataobject.UserOrgDO;
import com.chomolungma.system.user.infrastructure.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<UserDO> {
    List<UserOrgDO> pageUsersByIds(List<Long> ids);

    List<UserOrgDO> selectUsersByCondition(@Param("code") String code, @Param("userDO") UserDO userDO);
}
