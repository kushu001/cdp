package com.chomolungma.core;

public class CurrentProfileHolder {
    private static ThreadLocal<UserDetail> context = new ThreadLocal<>();

    public static void setContext(UserDetail account) {
        context.set(account);
    }

    public static UserDetail getProfile(){
        return context.get();
    }

    public static void remove(){
        context.remove();
    }
}
