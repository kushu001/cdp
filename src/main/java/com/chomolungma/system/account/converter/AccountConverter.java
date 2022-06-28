package com.chomolungma.system.account.converter;

import com.chomolungma.system.account.dataobject.AccountDO;
import com.chomolungma.system.account.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountConverter {
    AccountConverter INSTANCE = Mappers.getMapper(AccountConverter.class);

    AccountEntity toEntity(AccountDO accountDO);

    AccountDO toDO(AccountEntity accountEntity);
}
