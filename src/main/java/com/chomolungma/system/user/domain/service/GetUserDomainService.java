package com.chomolungma.system.user.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.domain.repository.mapper.UserMapper;
import org.springframework.context.ApplicationContext;

public class GetUserDomainService implements DomainService<UserEntity> {
    private Long id;
    public GetUserDomainService(Long id){
        this.id = id;
    }
    @Override
    public UserEntity execute(ApplicationContext context) {
       return context.getBean(UserMapper.class).selectById(id);
    }
}
