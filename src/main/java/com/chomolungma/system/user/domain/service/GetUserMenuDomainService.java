package com.chomolungma.system.user.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.menu.pojo.Menu;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserMenuDomainService implements DomainService<List<Menu>> {
    public List<Long> roleIds;

    public GetUserMenuDomainService(List<Long> roleIds){
        this.roleIds = roleIds;
    }
    @Override
    public List<Menu> execute(ApplicationContext context) {
        return null;
    }
}
