package com.chomolungma.system.user.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.user.domain.entity.UserEntity;
import org.springframework.context.ApplicationContext;

public class UpdateUserDomainService implements DomainService<Void> {
    private UserEntity userEntity;

    public UpdateUserDomainService(UserEntity userEntity){
        this.userEntity = userEntity;
    }
    @Override
    public Void execute(ApplicationContext context) {
        // TODO context.getBean(UserMapper.class).updateById(userEntity);
        return null;
    }
}
