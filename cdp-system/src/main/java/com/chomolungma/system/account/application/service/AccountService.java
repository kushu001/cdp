package com.chomolungma.system.account.application.service;

import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    Void resetPassword(Long id);

    Void bindUser(Long id, Long userId);

    Void createAccount(Account account);

    Void updateAccount(Account account);

    List<AccountDTO> getAccounts(Account account);
}
