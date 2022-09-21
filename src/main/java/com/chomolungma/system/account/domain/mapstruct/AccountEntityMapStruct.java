package com.chomolungma.system.account.domain.mapstruct;

import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.infrastructure.dataobject.AccountDO;
import com.chomolungma.system.account.infrastructure.dataobject.AccountUserRoleDO;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import com.chomolungma.system.account.interfaces.dto.AccountExcelDTO;
import com.chomolungma.system.account.interfaces.dto.AccountInDTO;
import com.chomolungma.system.account.interfaces.dto.AccountPageDTO;
import com.github.pagehelper.PageInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountEntityMapStruct {
    AccountEntityMapStruct INSTANCE = Mappers.getMapper(AccountEntityMapStruct.class);
    @Mappings({
            @Mapping(target = "records", source = "list"),
            @Mapping(target = "page", source = "pageNum")
    })
    AccountPageDTO toAccountPageDTO(PageInfo<AccountUserRoleDO> accountPage);

    Account toEntity(AccountInDTO accountInDTO);

    Account toEntity(AccountDTO accountDTO);

    Account toEntity(AccountExcelDTO accountExcelDTO);

    List<AccountExcelDTO> toExcelDTO(List<Account> accountEntities);

    AccountDTO toDTO(Account account);

    AccountDTO toDTO(AccountDO accountDO);
}
