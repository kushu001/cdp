package com.chomolungma.system.account.application.service;

import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.system.account.domain.assembler.AccountAssembler;
import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.domain.entity.Role;
import com.chomolungma.system.account.domain.repository.IAccountRepository;
import com.chomolungma.system.account.domain.repository.IAccountRoleRepository;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private IAccountRepository iAccountRepository;
    @Autowired
    private IAccountRoleRepository iAccountRoleRepository;

    @Override
    public Void resetPassword(Long id) {
        AccountDTO accountDTO = iAccountRepository.queryAccount(id);
        Account account = AccountAssembler.toEntity(accountDTO);
        account.resetPassword();
        iAccountRepository.save(account);
        return null;
    }

    @Override
    public Void bindUser(Long id, Long userId) {
        AccountDTO accountDTO = iAccountRepository.queryAccount(id);
        Account account = AccountAssembler.toEntity(accountDTO);
        account.bindUser(userId);
        iAccountRepository.save(account);
        return null;
    }

    @Override
    @Transactional
    public Void createAccount(Account account) {
        Account accountEntity = iAccountRepository.queryAccount(account.getUsername());
        if (accountEntity != null){
            throw new BusinessRuntimeException("账号名称已存在，请重新尝试！");
        }
        iAccountRepository.save(account);
        iAccountRoleRepository.remove(account.getId());
        for (Long roleId: account.getRoles().stream().map(Role::getId).collect(Collectors.toList())) {
            iAccountRoleRepository.save(account.getId(), roleId);
        }
        return null;
    }

    @Override
    @Transactional
    public Void updateAccount(Account account) {
        iAccountRepository.save(account);
        iAccountRoleRepository.remove(account.getId());
        for (Long roleId: account.getRoles().stream().map(Role::getId).collect(Collectors.toList())) {
            iAccountRoleRepository.save(account.getId(), roleId);
        }
        return null;
    }

    @Override
    public List<Account> getAccounts(Account account) {
        return iAccountRepository.queryAccounts(account);
    }
}
