package com.chomolungma.system.account.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.account.dataobject.AccountRoleDO;
import com.chomolungma.system.account.mapper.AccountRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRoleRepositoryImpl implements IAccountRoleRepository{

    @Autowired
    private AccountRoleMapper accountRoleMapper;

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
