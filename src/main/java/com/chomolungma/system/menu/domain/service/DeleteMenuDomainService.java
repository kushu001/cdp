package com.chomolungma.system.menu.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.menu.mapper.MenuMapper;
import org.springframework.context.ApplicationContext;

public class DeleteMenuDomainService implements DomainService<Void> {
    private Long id;
    public DeleteMenuDomainService(Long id){
        this.id = id;
    }
    @Override
    public Void execute(ApplicationContext context) {
        context.getBean(MenuMapper.class).deleteMenus(id);
        context.getBean(MenuMapper.class).deleteRoleMenuRelByMenuId(id);
        return null;
    }
}
