package com.chomolungma.system.account.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.account.infrastructure.converter.AccountConverter;
import com.chomolungma.system.account.infrastructure.converter.AccountUserConverter;
import com.chomolungma.system.account.infrastructure.dataobject.AccountDO;
import com.chomolungma.system.account.infrastructure.dataobject.AccountUserRoleDO;
import com.chomolungma.system.account.domain.assembler.AccountAssembler;
import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.domain.entity.Role;
import com.chomolungma.system.account.domain.repository.IAccountRepository;
import com.chomolungma.system.account.infrastructure.mybatis.repository.mapper.AccountMapper;
import com.chomolungma.system.account.infrastructure.mybatis.repository.mapper.AccountUserRoleMapper;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import com.chomolungma.system.account.interfaces.dto.AccountPageDTO;
import com.chomolungma.system.staff.infrastructure.dataobject.StaffDO;
import com.chomolungma.system.staff.infrastructure.mybatis.repository.mapper.StaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements IAccountRepository {
    private final AccountMapper accountMapper;
    private final AccountUserRoleMapper accountUserRoleMapper;
    private final StaffMapper staffMapper;


    public AccountRepositoryImpl(AccountMapper accountMapper, AccountUserRoleMapper accountUserRoleMapper, StaffMapper staffMapper){
        this.accountMapper = accountMapper;
        this.accountUserRoleMapper = accountUserRoleMapper;
        this.staffMapper = staffMapper;
    }
    @Override
    public Void save(Account account) {
        AccountDO accountDO = AccountConverter.INSTANCE.toDO(account);
        if (StringUtils.isEmpty(accountDO.getId())){
            accountMapper.insert(accountDO);
            account.setId(accountDO.getId());
        } else {
            accountMapper.updateById(accountDO);
        }
        return null;
    }

    @Override
    public Void remove(List<String> ids) {
        accountMapper.deleteBatchByIds(ids);
        return null;
    }

    @Override
    public AccountPageDTO findPageList(Account account, int current, int size) {
        AccountUserRoleDO accountUserRoleDO = AccountUserConverter.INSTANCE.toDO(account);
        PageHelper.startPage(current, size);
        List<AccountUserRoleDO> accountUsers = accountUserRoleMapper.selectList(accountUserRoleDO);
        PageInfo<AccountUserRoleDO> pageInfo = new PageInfo<>(accountUsers);
        return AccountAssembler.toAccountPageDTO(pageInfo);
    }

    @Override
    public Account findAccount(Long id) {
        AccountDO accountDO = accountMapper.selectById(id);
        List<Role> roles= accountMapper.selectRolesByAccountId(id);
        StaffDO userDO = staffMapper.selectById(accountDO.getUserId());
        Account account = AccountConverter.INSTANCE.toEntity(accountDO);
        account.setRoles(roles);
        account.setName(userDO != null ? userDO.getName():null);
        return account;
    }

    @Override
    public Account findAccount(String username) {
        AccountDO accountDO = accountMapper.selectOne(new QueryWrapper<AccountDO>().eq("username", username));
        if (accountDO == null) {
            return null;
        }
        List<Role> roles= accountMapper.selectRolesByAccountId(accountDO.getId());
        Account account = AccountConverter.INSTANCE.toEntity(accountDO);
        account.setRoles(roles);
        return account;
    }

    @Override
    public List<AccountDTO> findAccounts(Account account) {
        AccountUserRoleDO accountUserRoleDO = AccountUserConverter.INSTANCE.toDO(account);
        List<AccountUserRoleDO> accountUserRoleDOS = accountUserRoleMapper.selectList(accountUserRoleDO);
        return AccountUserConverter.INSTANCE.toEntity(accountUserRoleDOS);
    }

    @Override
    public List<String> findPermissions(Long accountId) {
        return accountMapper.getPermissions(accountId);
    }

    @Override
    public List<String> findResources(Long accountId) {
        return accountMapper.getResources(accountId);
    }

}
