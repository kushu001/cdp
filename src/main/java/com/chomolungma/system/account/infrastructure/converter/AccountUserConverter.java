package com.chomolungma.system.account.infrastructure.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.account.infrastructure.dataobject.AccountUserRoleDO;
import com.chomolungma.system.account.domain.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountUserConverter {
    AccountUserConverter INSTANCE = Mappers.getMapper(AccountUserConverter.class);

    Page<Account> toIPage(IPage<AccountUserRoleDO> accountUsers);

    AccountUserRoleDO toDO(Account account);

    Account toEntity(AccountUserRoleDO accountUserRoleDO);

    List<Account> toEntity(List<AccountUserRoleDO> accountUserRoleDOS);
}
