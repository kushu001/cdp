package com.chomolungma.system.account.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.account.dto.Account;
import com.chomolungma.system.account.dto.AccountPageDTO;
import com.chomolungma.system.account.entity.AccountEntity;

import java.util.List;

public interface AccountService {
    AccountPageDTO getAccounts(Page<AccountEntity> page, AccountEntity account);

    Account getAccount(Long id);

    Void resetPassword(Long id);

    Void bindUser(Long id, Long userId);

    Void createAccount(AccountEntity account);

    Void updateAccount(AccountEntity account);

    List<AccountEntity> getAccounts(AccountEntity account);
}
