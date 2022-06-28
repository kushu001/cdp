package com.chomolungma.system.account.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.account.converter.AccountConverter;
import com.chomolungma.system.account.converter.AccountUserConverter;
import com.chomolungma.system.account.dataobject.AccountDO;
import com.chomolungma.system.account.dataobject.AccountRoleDO;
import com.chomolungma.system.account.dataobject.AccountUserRoleDO;
import com.chomolungma.system.account.entity.AccountEntity;
import com.chomolungma.system.account.mapper.AccountMapper;
import com.chomolungma.system.account.mapper.AccountRoleMapper;
import com.chomolungma.system.account.mapper.AccountUserRoleMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AccountRepositoryImpl implements IAccountRepository{
    private AccountMapper accountMapper;
    private AccountUserRoleMapper accountUserRoleMapper;

    private AccountRoleMapper accountRoleMapper;

    public AccountRepositoryImpl(AccountMapper accountMapper, AccountUserRoleMapper accountUserRoleMapper, AccountRoleMapper accountRoleMapper){
        this.accountMapper = accountMapper;
        this.accountUserRoleMapper = accountUserRoleMapper;
        this.accountRoleMapper = accountRoleMapper;
    }
    @Override
    public Void save(AccountEntity accountEntity) {
        AccountDO accountDO = AccountConverter.INSTANCE.toDO(accountEntity);
        if (StringUtils.isEmpty(accountDO.getId())){
            accountMapper.insert(accountDO);
            accountEntity.setId(accountDO.getId());
        } else {
            accountMapper.updateById(accountDO);
        }
        return null;
    }

    @Override
    public Void remove(AccountEntity accountEntity) {
        accountMapper.deleteById(accountEntity.getId());
        return null;
    }

    @Override
    public Void remove(List<String> ids) {
        accountMapper.deleteBatchIds(ids);
        return null;
    }

    @Override
    public IPage<AccountEntity> queryPageList(Page<AccountEntity> page,AccountEntity accountEntity) {
        AccountUserRoleDO accountUserRoleDO = AccountUserConverter.INSTANCE.toDO(accountEntity);
        IPage<AccountUserRoleDO> accountUsers = accountUserRoleMapper.selectPageList(page, accountUserRoleDO);
        return AccountUserConverter.INSTANCE.toIPage(accountUsers);
    }

    @Override
    public AccountEntity queryAccountUser(String username, String password) {
        AccountUserRoleDO accountUserRoleDO = accountUserRoleMapper.selectAccount(username, password);
        List<AccountRoleDO> accountRoleDOS = accountRoleMapper.selectList(new QueryWrapper<AccountRoleDO>().eq("account_id", accountUserRoleDO.getId()));
        AccountEntity accountEntity = AccountUserConverter.INSTANCE.toEntity(accountUserRoleDO);
        List<Long> roleIds = accountRoleDOS.stream().map(AccountRoleDO::getRoleId).collect(Collectors.toList());
        accountEntity.setRoleIds(roleIds);
        return accountEntity;
    }

    @Override
    public AccountEntity queryAccount(Long id) {
        AccountDO accountDO = accountMapper.selectById(id);
        //List<AccountUserRoleDO> roles = accountUserRoleMapper.selectList(new QueryWrapper<AccountUserRoleDO>().eq("account_id", id));
        List<AccountRoleDO> roles = accountRoleMapper.selectList(new QueryWrapper<AccountRoleDO>().select("role_id").eq("account_id", id));
        AccountEntity accountEntity = AccountConverter.INSTANCE.toEntity(accountDO);
        accountEntity.setRoleIds(roles.stream().map(AccountRoleDO::getRoleId).collect(Collectors.toList()));
        return accountEntity;
    }

}
