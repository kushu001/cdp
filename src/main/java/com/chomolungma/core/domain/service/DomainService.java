package com.chomolungma.core.domain.service;

import org.springframework.context.ApplicationContext;

public interface DomainService<T>{
    T execute(ApplicationContext context);
    default boolean check(ApplicationContext context){return true;}
}
