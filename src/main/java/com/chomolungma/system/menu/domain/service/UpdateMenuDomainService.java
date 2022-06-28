package com.chomolungma.system.menu.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.mapper.MenuMapper;
import org.springframework.context.ApplicationContext;

public class UpdateMenuDomainService implements DomainService<Void> {
    private MenuEntity menuEntity;

    public UpdateMenuDomainService(MenuEntity menuEntity){
        this.menuEntity = menuEntity;
    }
    @Override
    public Void execute(ApplicationContext context) {
        context.getBean(MenuMapper.class).updateById(menuEntity);
        return null;
    }
}
