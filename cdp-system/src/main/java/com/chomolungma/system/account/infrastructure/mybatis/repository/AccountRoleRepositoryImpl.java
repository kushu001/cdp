package com.chomolungma.system.account.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.account.infrastructure.dataobject.AccountRoleDO;
import com.chomolungma.system.account.domain.repository.IAccountRoleRepository;
import com.chomolungma.system.account.infrastructure.mybatis.repository.mapper.AccountRoleMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRoleRepositoryImpl implements IAccountRoleRepository {

    private final AccountRoleMapper accountRoleMapper;

    public AccountRoleRepositoryImpl(AccountRoleMapper accountRoleMapper) {
        this.accountRoleMapper = accountRoleMapper;
    }

    @Override
    public Void save(Long accountId, Long roleId) {
        AccountRoleDO accountRoleDO = new AccountRoleDO();
        accountRoleDO.setAccountId(accountId);
        accountRoleDO.setRoleId(roleId);
        accountRoleMapper.insert(accountRoleDO);
        return null;
    }

    @Override
    public Void remove(Long accountId) {
        accountRoleMapper.delete(new QueryWrapper<AccountRoleDO>().eq("account_id",accountId));
        return null;
    }
}
