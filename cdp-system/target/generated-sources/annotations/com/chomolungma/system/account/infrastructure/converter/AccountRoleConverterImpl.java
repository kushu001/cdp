package com.chomolungma.system.account.infrastructure.converter;

import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.infrastructure.dataobject.AccountRoleDO;
import java.util.Date;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-14T10:38:23+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_312 (Azul Systems, Inc.)"
)
public class AccountRoleConverterImpl implements AccountRoleConverter {

    @Override
    public Account toEntity(AccountRoleDO accountRoleDO) {
        if ( accountRoleDO == null ) {
            return null;
        }

        Account account = new Account();

        account.setId( accountRoleDO.getId() );
        if ( accountRoleDO.getCreateTime() != null ) {
            account.setCreateTime( accountRoleDO.getCreateTime().toInstant() );
        }
        if ( accountRoleDO.getUpdateTime() != null ) {
            account.setUpdateTime( accountRoleDO.getUpdateTime().toInstant() );
        }
        account.setCreateUser( accountRoleDO.getCreateUser() );
        account.setUpdateUser( accountRoleDO.getUpdateUser() );
        account.setStatus( accountRoleDO.getStatus() );

        return account;
    }

    @Override
    public AccountRoleDO toDO(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountRoleDO accountRoleDO = new AccountRoleDO();

        accountRoleDO.setId( account.getId() );
        if ( account.getCreateTime() != null ) {
            accountRoleDO.setCreateTime( Date.from( account.getCreateTime() ) );
        }
        if ( account.getUpdateTime() != null ) {
            accountRoleDO.setUpdateTime( Date.from( account.getUpdateTime() ) );
        }
        accountRoleDO.setCreateUser( account.getCreateUser() );
        accountRoleDO.setUpdateUser( account.getUpdateUser() );
        accountRoleDO.setStatus( account.getStatus() );

        return accountRoleDO;
    }
}
