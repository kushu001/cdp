package com.chomolungma.system.account.converter;

import com.chomolungma.system.account.dataobject.AccountRoleDO;
import com.chomolungma.system.account.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountRoleConverter {
    AccountRoleConverter INSTANCE = Mappers.getMapper(AccountRoleConverter.class);

    AccountEntity toEntity(AccountRoleDO accountRoleDO);

    AccountRoleDO toDO(AccountEntity accountEntity);
}
