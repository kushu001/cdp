package com.chomolungma.system.role.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.domain.repository.mapper.RoleMapper;
import org.springframework.context.ApplicationContext;

public class NewRoleDomainService implements DomainService<Void> {
    private RoleEntity roleEntity;

    public NewRoleDomainService(RoleEntity roleEntity){
        this.roleEntity = roleEntity;
    }

    @Override
    public Void execute(ApplicationContext context) {
        context.getBean(RoleMapper.class).insert(roleEntity);
        return null;
    }
}
