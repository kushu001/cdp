package com.chomolungma.system.role.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.domain.repository.mapper.RoleMapper;
import org.springframework.context.ApplicationContext;

public class OneRoleDomainService implements DomainService<RoleEntity> {
    private Long id;

    public OneRoleDomainService(Long id){
        this.id = id;
    }

    @Override
    public RoleEntity execute(ApplicationContext context) {
        return context.getBean(RoleMapper.class).selectById(id);
    }
}
