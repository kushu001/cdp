package com.chomolungma.system.account.infrastructure.converter;

import com.chomolungma.system.account.infrastructure.dataobject.AccountRoleDO;
import com.chomolungma.system.account.domain.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountRoleConverter {
    AccountRoleConverter INSTANCE = Mappers.getMapper(AccountRoleConverter.class);

    Account toEntity(AccountRoleDO accountRoleDO);

    AccountRoleDO toDO(Account account);
}
