package com.chomolungma.system.account.assembler;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chomolungma.system.account.dto.AccountDTO;
import com.chomolungma.system.account.dto.AccountInDTO;
import com.chomolungma.system.account.dto.AccountPageDTO;
import com.chomolungma.system.account.entity.AccountEntity;
import com.chomolungma.system.account.mapstruct.AccountEntityMapStruct;

import java.util.List;

public class AccountAssembler {
    public static AccountPageDTO toAccountPageDTO(IPage<AccountEntity> page){
        return AccountEntityMapStruct.INSTANCE.toAccountPageDTO(page);
    }

    public static AccountEntity toEntity(AccountInDTO accountInDTO){
        return AccountEntityMapStruct.INSTANCE.toEntity(accountInDTO);
    }

    public static AccountEntity toEntity(AccountDTO accountDTO){
        return AccountEntityMapStruct.INSTANCE.toEntity(accountDTO);
    }

    public static List<AccountDTO> toDTO(List<AccountEntity> accountEntities){
        return AccountEntityMapStruct.INSTANCE.toDTO(accountEntities);
    }
}
