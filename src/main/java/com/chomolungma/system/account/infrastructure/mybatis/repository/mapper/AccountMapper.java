package com.chomolungma.system.account.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.account.infrastructure.dataobject.AccountDO;
import com.chomolungma.system.account.infrastructure.dto.RoleDTO;

import java.util.List;

public interface AccountMapper extends BaseMapper<AccountDO> {
    List<RoleDTO> selectRolesByAccountId(Long accountId);
}
