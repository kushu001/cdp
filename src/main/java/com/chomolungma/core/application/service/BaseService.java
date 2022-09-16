package com.chomolungma.core.application.service;

import com.chomolungma.common.SpringContextUtils;
import com.chomolungma.core.domain.service.DomainService;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
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
