package com.chomolungma.system.account.infrastructure.converter;

import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.infrastructure.dataobject.AccountUserRoleDO;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class AccountUserConverterImpl implements AccountUserConverter {

    @Override
    public AccountUserRoleDO toDO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountUserRoleDO accountUserRoleDO = new AccountUserRoleDO();

        accountUserRoleDO.setId( account.getId() );
        if ( account.getCreateTime() != null ) {
            accountUserRoleDO.setCreateTime( Date.from( account.getCreateTime() ) );
        }
        if ( account.getUpdateTime() != null ) {
            accountUserRoleDO.setUpdateTime( Date.from( account.getUpdateTime() ) );
        }
        accountUserRoleDO.setCreateUser( account.getCreateUser() );
        accountUserRoleDO.setUpdateUser( account.getUpdateUser() );
        accountUserRoleDO.setStatus( account.getStatus() );
        accountUserRoleDO.setUsername( account.getUsername() );
        accountUserRoleDO.setNickname( account.getNickname() );
        accountUserRoleDO.setName( account.getName() );
        accountUserRoleDO.setAvatar( account.getAvatar() );
        accountUserRoleDO.setEnabled( account.getEnabled() );

        return accountUserRoleDO;
    }

    @Override
    public Account toEntity(AccountUserRoleDO accountUserRoleDO) {
        if ( accountUserRoleDO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( accountUserRoleDO.getId() );
        if ( accountUserRoleDO.getCreateTime() != null ) {
            account.setCreateTime( accountUserRoleDO.getCreateTime().toInstant() );
        }
        if ( accountUserRoleDO.getUpdateTime() != null ) {
            account.setUpdateTime( accountUserRoleDO.getUpdateTime().toInstant() );
        }
        account.setCreateUser( accountUserRoleDO.getCreateUser() );
        account.setUpdateUser( accountUserRoleDO.getUpdateUser() );
        account.setStatus( accountUserRoleDO.getStatus() );
        account.setUsername( accountUserRoleDO.getUsername() );
        account.setName( accountUserRoleDO.getName() );
        account.setNickname( accountUserRoleDO.getNickname() );
        account.setAvatar( accountUserRoleDO.getAvatar() );
        account.setEnabled( accountUserRoleDO.getEnabled() );

        return account;
    }

    @Override
    public List<AccountDTO> toEntity(List<AccountUserRoleDO> accountUserRoleDOS) {
        if ( accountUserRoleDOS == null ) {
            return null;
        }

        List<AccountDTO> list = new ArrayList<AccountDTO>( accountUserRoleDOS.size() );
        for ( AccountUserRoleDO accountUserRoleDO : accountUserRoleDOS ) {
            list.add( accountUserRoleDOToAccountDTO( accountUserRoleDO ) );
        }

        return list;
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
}
