package com.chomolungma.system.account.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.account.infrastructure.dataobject.AccountUserRoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountUserRoleMapper extends BaseMapper<AccountUserRoleDO> {
    IPage<AccountUserRoleDO> selectList(IPage<?> page,@Param("accountUserRole")  AccountUserRoleDO accountUserRoleDO);

    AccountUserRoleDO selectAccount(@Param("username") String username, @Param("password") String password);

    List<AccountUserRoleDO> selectList(@Param("accountUserRole") AccountUserRoleDO accountUserRoleDO);
}
