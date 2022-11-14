package com.chomolungma.system.account.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.account.domain.assembler.AccountAssembler;
import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.domain.entity.Role;
import com.chomolungma.system.account.domain.repository.IAccountRepository;
import com.chomolungma.system.account.infrastructure.converter.AccountConverter;
import com.chomolungma.system.account.infrastructure.converter.AccountUserConverter;
import com.chomolungma.system.account.infrastructure.dataobject.AccountDO;
import com.chomolungma.system.account.infrastructure.dataobject.AccountUserRoleDO;
import com.chomolungma.system.account.infrastructure.dto.RoleDTO;
import com.chomolungma.system.account.infrastructure.mybatis.repository.mapper.AccountMapper;
import com.chomolungma.system.account.infrastructure.mybatis.repository.mapper.AccountUserRoleMapper;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import com.chomolungma.system.account.interfaces.dto.AccountPageDTO;
import com.chomolungma.system.user.infrastructure.mybatis.repository.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AccountRepositoryImpl implements IAccountRepository {
    private AccountMapper accountMapper;
    private AccountUserRoleMapper accountUserRoleMapper;
    private UserMapper userMapper;


    public AccountRepositoryImpl(AccountMapper accountMapper, AccountUserRoleMapper accountUserRoleMapper, UserMapper userMapper){
        this.accountMapper = accountMapper;
        this.accountUserRoleMapper = accountUserRoleMapper;
        this.userMapper = userMapper;
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
        //accountMapper.deleteBatchIds(ids);
        accountMapper.deleteBatchByIds(ids);
        return null;
    }

    @Override
    public AccountPageDTO queryPageList(Account account, int current, int size) {
        AccountUserRoleDO accountUserRoleDO = AccountUserConverter.INSTANCE.toDO(account);
        PageHelper.startPage(current, size);
        List<AccountUserRoleDO> accountUsers = accountUserRoleMapper.selectList(accountUserRoleDO);
        PageInfo<AccountUserRoleDO> pageInfo = new PageInfo<>(accountUsers);
        return AccountAssembler.toAccountPageDTO(pageInfo);
    }

    @Override
    public Account queryAccountUser(String username, String password) {
        AccountUserRoleDO accountUserRoleDO = accountUserRoleMapper.selectAccount(username, password);
        List<RoleDTO> roles= accountMapper.selectRolesByAccountId(accountUserRoleDO.getId());
        Account account = AccountUserConverter.INSTANCE.toEntity(accountUserRoleDO);
        account.setRoles(AccountConverter.INSTANCE.toEntity(roles));
        return account;
    }

    @Override
    public AccountDTO queryAccount(Long id) {
        AccountDO accountDO = accountMapper.selectById(id);
        List<RoleDTO> roles= accountMapper.selectRolesByAccountId(id);
        AccountDTO accountDTO = AccountAssembler.toDTO(accountDO);
        accountDTO.setRoleIds(roles.stream().map(RoleDTO::getId).collect(Collectors.toList()));
        accountDTO.setRoleName(roles.stream().map(RoleDTO::getName).collect(Collectors.joining(",")));
        accountDTO.setName(userMapper.selectById(accountDO.getUserId()).getName());
        return accountDTO;
    }

    @Override
    public Account queryAccount(String username) {
        AccountDO accountDO = accountMapper.selectOne(new QueryWrapper<AccountDO>().eq("username", username));
        if (accountDO == null) {
            return null;
        }
        List<RoleDTO> roles= accountMapper.selectRolesByAccountId(accountDO.getId());
        Account account = AccountConverter.INSTANCE.toEntity(accountDO);

        List<Role> roleEntities = new ArrayList<>();
        for (RoleDTO roleDto: roles) {
            Role role = new Role();
            role.setId(roleDto.getId());
            role.setName(role.getName());
            roleEntities.add(role);
        }
        account.setRoles(roleEntities);
        return account;
    }

    @Override
    public List<Account> queryAccounts(Account account) {
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
