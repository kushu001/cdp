package com.chomolungma.system.account.domain.repository;

import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import com.chomolungma.system.account.interfaces.dto.AccountPageDTO;

import java.util.List;

public interface IAccountRepository {
    Void save(Account account);
    Void remove(List<String> ids);
    AccountPageDTO findPageList(Account account, int current, int size);
    Account findAccount(Long id);
    Account findAccount(String username);
    List<AccountDTO> findAccounts(Account account);
    List<String> findPermissions(Long accountId);

    List<String> findResources(Long accountId);
}
