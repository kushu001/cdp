package com.chomolungma.system.account.mapstruct;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.account.dto.AccountDTO;
import com.chomolungma.system.account.dto.AccountExcelDTO;
import com.chomolungma.system.account.dto.AccountInDTO;
import com.chomolungma.system.account.dto.AccountPageDTO;
import com.chomolungma.system.account.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountEntityMapStruct {
    AccountEntityMapStruct INSTANCE = Mappers.getMapper(AccountEntityMapStruct.class);

    AccountPageDTO toAccountPageDTO(IPage<AccountEntity> accountPage);

    AccountEntity toEntity(AccountInDTO accountInDTO);

    AccountEntity toEntity(AccountDTO accountDTO);

    List<AccountExcelDTO> toExcelDTO(List<AccountEntity> accountEntities);

    AccountDTO toDTO(AccountEntity accountEntity);
}
