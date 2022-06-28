package com.chomolungma.system.account.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.account.entity.AccountEntity;

import java.util.List;

public interface IAccountRepository {
    Void save(AccountEntity accountEntity);
    Void remove(AccountEntity accountEntity);
    Void remove(List<String> ids);
    IPage<AccountEntity> queryPageList(Page<AccountEntity> page,AccountEntity accountEntity);
    AccountEntity queryAccountUser(String username, String password);
    AccountEntity queryAccount(Long id);
}
