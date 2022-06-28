package com.chomolungma.core;

import com.chomolungma.system.account.entity.AccountEntity;

public class CurrentProfileHolder {
    private static ThreadLocal<AccountEntity> context = new ThreadLocal<>();

    public static void setContext(AccountEntity accountEntity) {
        context.set(accountEntity);
    }

    public static AccountEntity getProfile(){
        return context.get();
    }

    public static void remove(){
        context.remove();
    }
}
