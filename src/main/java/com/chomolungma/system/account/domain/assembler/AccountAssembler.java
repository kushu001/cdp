package com.chomolungma.system.account.domain.assembler;

import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.domain.entity.Role;
import com.chomolungma.system.account.domain.mapstruct.AccountEntityMapStruct;
import com.chomolungma.system.account.infrastructure.dataobject.AccountDO;
import com.chomolungma.system.account.infrastructure.dataobject.AccountUserRoleDO;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import com.chomolungma.system.account.interfaces.dto.AccountExcelDTO;
import com.chomolungma.system.account.interfaces.dto.AccountInDTO;
import com.chomolungma.system.account.interfaces.dto.AccountPageDTO;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountAssembler {
    public static AccountPageDTO toAccountPageDTO(PageInfo<AccountUserRoleDO> page){
        return AccountEntityMapStruct.INSTANCE.toAccountPageDTO(page);
    }

    public static Account toEntity(AccountInDTO accountInDTO){
        Account account = AccountEntityMapStruct.INSTANCE.toEntity(accountInDTO);
        List<Role> roles = new ArrayList<>();
        for (Long roleId: accountInDTO.getRoleIds()) {
            Role role = new Role();
            role.setId(roleId);
            roles.add(role);
        }
        account.setRoles(roles);
        return account;
    }

    public static Account toEntity(AccountDTO accountDTO){
        return AccountEntityMapStruct.INSTANCE.toEntity(accountDTO);
    }

    public static Account toEntity(AccountExcelDTO accountExcelDTO){
        return AccountEntityMapStruct.INSTANCE.toEntity(accountExcelDTO);
    }

    public static List<AccountExcelDTO> toExcelDTO(List<Account> accountEntities){
        return AccountEntityMapStruct.INSTANCE.toExcelDTO(accountEntities);
    }

    public static AccountDTO toDTO(Account account){
        AccountDTO accountDTO = AccountEntityMapStruct.INSTANCE.toDTO(account);
        accountDTO.setRoleIds(account.getRoles().stream().map(Role::getId).collect(Collectors.toList()));
        return accountDTO;
    }

    public static AccountDTO toDTO(AccountDO accountDO){
        return AccountEntityMapStruct.INSTANCE.toDTO(accountDO);
    }
}
