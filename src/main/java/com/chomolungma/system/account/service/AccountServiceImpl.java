package com.chomolungma.system.account.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.account.assembler.AccountAssembler;
import com.chomolungma.system.account.dto.Account;
import com.chomolungma.system.account.dto.AccountPageDTO;
import com.chomolungma.system.account.entity.AccountEntity;
import com.chomolungma.system.account.repository.IAccountRepository;
import com.chomolungma.system.account.repository.IAccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private IAccountRepository iAccountRepository;
    @Autowired
    private IAccountRoleRepository iAccountRoleRepository;
    @Override
    public AccountPageDTO getAccounts(Page<AccountEntity> page, AccountEntity account) {
        IPage<AccountEntity> accounts = iAccountRepository.queryPageList(page, account);
        return AccountAssembler.toAccountPageDTO(accounts);
    }

    @Override
    public Account getAccount(Long id) {
        AccountEntity accountEntity = iAccountRepository.queryAccount(id);

        return null;
    }

    @Override
    public Void resetPassword(Long id) {
        AccountEntity accountEntity = iAccountRepository.queryAccount(id);
        accountEntity.resetPassword();
        iAccountRepository.save(accountEntity);
        return null;
    }

    @Override
    public Void bindUser(Long id, Long userId) {
        AccountEntity accountEntity = iAccountRepository.queryAccount(id);
        accountEntity.bindUser(userId);
        iAccountRepository.save(accountEntity);
        return null;
    }

    @Override
    @Transactional
    public Void createAccount(AccountEntity account) {
        iAccountRepository.save(account);
        iAccountRoleRepository.remove(account.getId());
        for (Long roleId: account.getRoleIds()) {
            iAccountRoleRepository.save(account.getId(), roleId);
        }
        return null;
    }

    @Override
    @Transactional
    public Void updateAccount(AccountEntity account) {
        iAccountRepository.save(account);
        iAccountRoleRepository.remove(account.getId());
        for (Long roleId: account.getRoleIds()) {
            iAccountRoleRepository.save(account.getId(), roleId);
        }
        return null;
    }
}
