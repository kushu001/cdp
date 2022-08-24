package com.chomolungma.system.account.converter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.account.dataobject.AccountUserRoleDO;
import com.chomolungma.system.account.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountUserConverter {
    AccountUserConverter INSTANCE = Mappers.getMapper(AccountUserConverter.class);

    Page<AccountEntity> toIPage(IPage<AccountUserRoleDO> accountUsers);

    AccountUserRoleDO toDO(AccountEntity accountEntity);

    AccountEntity toEntity(AccountUserRoleDO accountUserRoleDO);

    List<AccountEntity> toEntity(List<AccountUserRoleDO> accountUserRoleDOS);
}
