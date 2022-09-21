package com.chomolungma.system.account.infrastructure.converter;

import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.domain.entity.Role;
import com.chomolungma.system.account.infrastructure.dataobject.AccountDO;
import com.chomolungma.system.account.infrastructure.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountConverter {
    AccountConverter INSTANCE = Mappers.getMapper(AccountConverter.class);

    Account toEntity(AccountDO accountDO);

    AccountDO toDO(Account account);

    List<Role> toEntity(List<RoleDTO> roleDTOS);
}
