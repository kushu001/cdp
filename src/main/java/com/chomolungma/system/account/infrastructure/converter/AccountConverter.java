package com.chomolungma.system.account.infrastructure.converter;

import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.infrastructure.dataobject.AccountDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountConverter {
    AccountConverter INSTANCE = Mappers.getMapper(AccountConverter.class);

    Account toEntity(AccountDO accountDO);

    AccountDO toDO(Account account);
}
