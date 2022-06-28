package com.chomolungma.system.account.repository;

public interface IAccountRoleRepository {
    Void save(Long accountId, Long roleId);

    Void remove(Long accountId);

}
