package com.chomolungma.core;

import com.chomolungma.system.account.interfaces.dto.AccountDTO;

public class CurrentProfileHolder {
    private static ThreadLocal<AccountDTO> context = new ThreadLocal<>();

    public static void setContext(AccountDTO account) {
        context.set(account);
    }

    public static AccountDTO getProfile(){
        return context.get();
    }

    public static void remove(){
        context.remove();
    }
}
