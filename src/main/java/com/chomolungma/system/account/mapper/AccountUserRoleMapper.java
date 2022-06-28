package com.chomolungma.system.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.account.dataobject.AccountUserRoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AccountUserRoleMapper extends BaseMapper<AccountUserRoleDO> {
    IPage<AccountUserRoleDO> selectPageList(IPage<?> page,@Param("accountUserRole")  AccountUserRoleDO accountUserRoleDO);

    AccountUserRoleDO selectAccount(@Param("username") String username, @Param("password") String password);
}
