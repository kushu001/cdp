package com.chomolungma.system.account.infrastructure.converter;

import com.chomolungma.system.account.infrastructure.dataobject.AccountUserRoleDO;
import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountUserConverter {
    AccountUserConverter INSTANCE = Mappers.getMapper(AccountUserConverter.class);
    AccountUserRoleDO toDO(Account account);
    Account toEntity(AccountUserRoleDO accountUserRoleDO);
    List<AccountDTO> toEntity(List<AccountUserRoleDO> accountUserRoleDOS);
}
