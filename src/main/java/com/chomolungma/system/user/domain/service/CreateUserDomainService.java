package com.chomolungma.system.user.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.user.domain.entity.OrgUserEntity;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.infrastructure.dataobject.UserDO;
import com.chomolungma.system.user.infrastructure.mybatis.repository.mapper.UserMapper;
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
        // context.getBean(UserMapper.class).insert(userEntity);
        OrgUserEntity orgUserEntity = new OrgUserEntity();
        orgUserEntity.setOrgId(orgId);
        orgUserEntity.setUserId(userEntity.getId());
        //context.getBean(OrgUserMapper.class).insert(orgUserEntity);
        return null;
    }

    @Override
    public boolean check(ApplicationContext context) {
        UserDO user = context.getBean(UserMapper.class).selectOne(new QueryWrapper<UserDO>().eq("id_number", userEntity.getIdNumber()));
        if (user != null) {
            throw new BusinessRuntimeException("用户身份证号已存在，请查证后再建！");
        }
        return true;
    }
}
