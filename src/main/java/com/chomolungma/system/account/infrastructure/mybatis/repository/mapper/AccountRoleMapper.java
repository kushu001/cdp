package com.chomolungma.system.account.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.account.infrastructure.dataobject.AccountRoleDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRoleMapper extends BaseMapper<AccountRoleDO> {
}
