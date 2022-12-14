package com.chomolungma.system.account.domain.mapstruct;

import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.infrastructure.dataobject.AccountDO;
import com.chomolungma.system.account.infrastructure.dataobject.AccountUserRoleDO;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import com.chomolungma.system.account.interfaces.dto.AccountExcelDTO;
import com.chomolungma.system.account.interfaces.dto.AccountInDTO;
import com.chomolungma.system.account.interfaces.dto.AccountPageDTO;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class AccountEntityMapStructImpl implements AccountEntityMapStruct {

    @Override
    public AccountPageDTO toAccountPageDTO(PageInfo<AccountUserRoleDO> accountPage) {
        if ( accountPage == null ) {
            return null;
        }

        AccountPageDTO accountPageDTO = new AccountPageDTO();

        accountPageDTO.setRecords( accountUserRoleDOListToAccountDTOList( accountPage.getList() ) );
        accountPageDTO.setPage( accountPage.getPageNum() );
        accountPageDTO.setTotal( accountPage.getTotal() );

        return accountPageDTO;
    }

    @Override
    public AccountPageDTO toAccountPageDTO2(PageInfo<AccountDTO> accountPage) {
        if ( accountPage == null ) {
            return null;
        }

        AccountPageDTO accountPageDTO = new AccountPageDTO();

        List<AccountDTO> list = accountPage.getList();
        if ( list != null ) {
            accountPageDTO.setRecords( new ArrayList<AccountDTO>( list ) );
        }
        accountPageDTO.setPage( accountPage.getPageNum() );
        accountPageDTO.setTotal( accountPage.getTotal() );

        return accountPageDTO;
    }

    @Override
    public Account toEntity(AccountInDTO accountInDTO) {
        if ( accountInDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( accountInDTO.getId() );
        account.setStatus( accountInDTO.getStatus() );
        account.setUserId( accountInDTO.getUserId() );
        account.setUsername( accountInDTO.getUsername() );
        account.setNickname( accountInDTO.getNickname() );
        account.setAvatar( accountInDTO.getAvatar() );
        account.setEnabled( accountInDTO.getEnabled() );

        return account;
    }

    @Override
    public Account toEntity(AccountDTO accountDTO) {
        if ( accountDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( accountDTO.getId() );
        if ( accountDTO.getCreateTime() != null ) {
            account.setCreateTime( accountDTO.getCreateTime().toInstant() );
        }
        if ( accountDTO.getUpdateTime() != null ) {
            account.setUpdateTime( accountDTO.getUpdateTime().toInstant() );
        }
        account.setCreateUser( accountDTO.getCreateUser() );
        account.setUpdateUser( accountDTO.getUpdateUser() );
        account.setStatus( accountDTO.getStatus() );
        account.setUserId( accountDTO.getUserId() );
        account.setUsername( accountDTO.getUsername() );
        account.setName( accountDTO.getName() );
        account.setNickname( accountDTO.getNickname() );
        account.setAvatar( accountDTO.getAvatar() );
        account.setEnabled( accountDTO.getEnabled() );

        return account;
    }

    @Override
    public Account toEntity(AccountExcelDTO accountExcelDTO) {
        if ( accountExcelDTO == null ) {
            return null;
        }

        Account account = new Account();

        account.setUsername( accountExcelDTO.getUsername() );
        account.setName( accountExcelDTO.getName() );
        account.setNickname( accountExcelDTO.getNickname() );
        account.setAvatar( accountExcelDTO.getAvatar() );

        return account;
    }

    @Override
    public List<AccountExcelDTO> toExcelDTO(List<Account> accountEntities) {
        if ( accountEntities == null ) {
            return null;
        }

        List<AccountExcelDTO> list = new ArrayList<AccountExcelDTO>( accountEntities.size() );
        for ( Account account : accountEntities ) {
            list.add( accountToAccountExcelDTO( account ) );
        }

        return list;
    }

    @Override
    public AccountDTO toDTO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId( account.getId() );
        if ( account.getCreateTime() != null ) {
            accountDTO.setCreateTime( Date.from( account.getCreateTime() ) );
        }
        if ( account.getUpdateTime() != null ) {
            accountDTO.setUpdateTime( Date.from( account.getUpdateTime() ) );
        }
        accountDTO.setCreateUser( account.getCreateUser() );
        accountDTO.setUpdateUser( account.getUpdateUser() );
        accountDTO.setStatus( account.getStatus() );
        accountDTO.setUserId( account.getUserId() );
        accountDTO.setUsername( account.getUsername() );
        accountDTO.setName( account.getName() );
        accountDTO.setNickname( account.getNickname() );
        accountDTO.setAvatar( account.getAvatar() );
        accountDTO.setEnabled( account.getEnabled() );

        return accountDTO;
    }

    @Override
    public AccountDTO toDTO(AccountDO accountDO) {
        if ( accountDO == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId( accountDO.getId() );
        accountDTO.setCreateTime( accountDO.getCreateTime() );
        accountDTO.setUpdateTime( accountDO.getUpdateTime() );
        accountDTO.setCreateUser( accountDO.getCreateUser() );
        accountDTO.setUpdateUser( accountDO.getUpdateUser() );
        accountDTO.setStatus( accountDO.getStatus() );
        accountDTO.setUserId( accountDO.getUserId() );
        accountDTO.setUsername( accountDO.getUsername() );
        accountDTO.setNickname( accountDO.getNickname() );
        accountDTO.setAvatar( accountDO.getAvatar() );
        accountDTO.setEnabled( accountDO.getEnabled() );

        return accountDTO;
    }

    protected AccountDTO accountUserRoleDOToAccountDTO(AccountUserRoleDO accountUserRoleDO) {
        if ( accountUserRoleDO == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId( accountUserRoleDO.getId() );
        accountDTO.setCreateTime( accountUserRoleDO.getCreateTime() );
        accountDTO.setUpdateTime( accountUserRoleDO.getUpdateTime() );
        accountDTO.setCreateUser( accountUserRoleDO.getCreateUser() );
        accountDTO.setUpdateUser( accountUserRoleDO.getUpdateUser() );
        accountDTO.setStatus( accountUserRoleDO.getStatus() );
        accountDTO.setUsername( accountUserRoleDO.getUsername() );
        accountDTO.setRoleName( accountUserRoleDO.getRoleName() );
        accountDTO.setName( accountUserRoleDO.getName() );
        accountDTO.setNickname( accountUserRoleDO.getNickname() );
        accountDTO.setAvatar( accountUserRoleDO.getAvatar() );
        accountDTO.setEnabled( accountUserRoleDO.getEnabled() );

        return accountDTO;
    }

    protected List<AccountDTO> accountUserRoleDOListToAccountDTOList(List<AccountUserRoleDO> list) {
        if ( list == null ) {
            return null;
        }

        List<AccountDTO> list1 = new ArrayList<AccountDTO>( list.size() );
        for ( AccountUserRoleDO accountUserRoleDO : list ) {
            list1.add( accountUserRoleDOToAccountDTO( accountUserRoleDO ) );
        }

        return list1;
    }

    protected AccountExcelDTO accountToAccountExcelDTO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountExcelDTO accountExcelDTO = new AccountExcelDTO();

        accountExcelDTO.setUsername( account.getUsername() );
        accountExcelDTO.setName( account.getName() );
        accountExcelDTO.setNickname( account.getNickname() );
        accountExcelDTO.setAvatar( account.getAvatar() );

        return accountExcelDTO;
    }
}
