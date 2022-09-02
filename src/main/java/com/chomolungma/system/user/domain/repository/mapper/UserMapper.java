package com.chomolungma.system.user.domain.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.domain.repository.dataobject.UserDO;
import com.chomolungma.system.user.domain.repository.dataobject.UserOrgDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<UserEntity> {
    List<UserOrgDO> pageUsersByIds(List<Long> ids);

    List<UserOrgDO> selectUsersByCondition(@Param("code") String code, @Param("userDO") UserDO userDO);
}
