package com.chomolungma.system.account.infrastructure.converter;

import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.infrastructure.dataobject.AccountDO;
import java.util.Date;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class AccountConverterImpl implements AccountConverter {

    @Override
    public Account toEntity(AccountDO accountDO) {
        if ( accountDO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( accountDO.getId() );
        if ( accountDO.getCreateTime() != null ) {
            account.setCreateTime( accountDO.getCreateTime().toInstant() );
        }
        if ( accountDO.getUpdateTime() != null ) {
            account.setUpdateTime( accountDO.getUpdateTime().toInstant() );
        }
        account.setCreateUser( accountDO.getCreateUser() );
        account.setUpdateUser( accountDO.getUpdateUser() );
        account.setStatus( accountDO.getStatus() );
        account.setUserId( accountDO.getUserId() );
        account.setUsername( accountDO.getUsername() );
        account.setPassword( accountDO.getPassword() );
        account.setNickname( accountDO.getNickname() );
        account.setAvatar( accountDO.getAvatar() );
        account.setEnabled( accountDO.getEnabled() );

        return account;
    }

    @Override
    public AccountDO toDO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDO accountDO = new AccountDO();

        accountDO.setId( account.getId() );
        if ( account.getCreateTime() != null ) {
            accountDO.setCreateTime( Date.from( account.getCreateTime() ) );
        }
        if ( account.getUpdateTime() != null ) {
            accountDO.setUpdateTime( Date.from( account.getUpdateTime() ) );
        }
        accountDO.setCreateUser( account.getCreateUser() );
        accountDO.setUpdateUser( account.getUpdateUser() );
        accountDO.setStatus( account.getStatus() );
        accountDO.setUsername( account.getUsername() );
        accountDO.setUserId( account.getUserId() );
        accountDO.setNickname( account.getNickname() );
        accountDO.setPassword( account.getPassword() );
        accountDO.setAvatar( account.getAvatar() );
        accountDO.setEnabled( account.getEnabled() );

        return accountDO;
    }
}
