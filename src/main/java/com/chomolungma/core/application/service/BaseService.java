package com.chomolungma.core.application.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.common.SpringContextUtils;
import org.springframework.context.ApplicationContext;

public class BaseService {
    private ApplicationContext context;

    public BaseService(){
        this.context = SpringContextUtils.getApplicationContext();
    }

    public <T> T execute(DomainService<T> domainService){
        boolean bool = domainService.check(context);
        if (bool)
        return domainService.execute(this.context);
        else
            return null;

    }

}
