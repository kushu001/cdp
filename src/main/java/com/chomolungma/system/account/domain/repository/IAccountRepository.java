package com.chomolungma.system.account.domain.repository;

import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import com.chomolungma.system.account.interfaces.dto.AccountPageDTO;

import java.util.List;

public interface IAccountRepository {
    Void save(Account account);
    Void remove(Account account);
    Void remove(List<String> ids);
    AccountPageDTO queryPageList(Account account, int current, int size);
    Account queryAccountUser(String username, String password);
    AccountDTO queryAccount(Long id);
    Account queryAccount(String username);
    List<Account> queryAccounts(Account account);
    List<String> findPermissions(Long accountId);
}
