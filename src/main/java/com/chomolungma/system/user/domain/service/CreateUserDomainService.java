package com.chomolungma.system.user.domain.service;

import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.user.domain.entity.OrgUserEntity;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.domain.repository.mapper.OrgUserMapper;
import com.chomolungma.system.user.domain.repository.mapper.UserMapper;
import org.springframework.context.ApplicationContext;

public class CreateUserDomainService implements DomainService<Void> {
    private UserEntity userEntity;
    private Long orgId;

    public CreateUserDomainService(Long orgId, UserEntity userEntity){
        this.orgId = orgId;
        this.userEntity = userEntity;
    }

    @Override
    public Void execute(ApplicationContext context) {
        context.getBean(UserMapper.class).insert(userEntity);
        OrgUserEntity orgUserEntity = new OrgUserEntity();
        orgUserEntity.setOrgId(orgId);
        orgUserEntity.setUserId(userEntity.getId());
        context.getBean(OrgUserMapper.class).insert(orgUserEntity);
        return null;
    }
}
