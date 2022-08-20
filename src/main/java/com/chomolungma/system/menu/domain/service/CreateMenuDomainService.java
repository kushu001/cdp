package com.chomolungma.system.menu.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.mapper.MenuMapper;
import org.springframework.context.ApplicationContext;

public class CreateMenuDomainService implements DomainService<Void> {
    private MenuEntity menuEntity;

    public CreateMenuDomainService(MenuEntity menuEntity){
        this.menuEntity = menuEntity;
    }
    @Override
    public Void execute(ApplicationContext context) {
        // 如果pid为空，则此节点为根结点，需要将pid设置成0
        if (menuEntity.getPid() == null){
            menuEntity.setPid(0l);
        }
        context.getBean(MenuMapper.class).insert(menuEntity);
        return null;
    }
}
