package com.chomolungma.system.user.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.mapper.OrgMapper;
import com.chomolungma.system.user.domain.entity.OrgUserEntity;
import com.chomolungma.system.user.domain.repository.mapper.OrgUserMapper;
import com.chomolungma.system.user.domain.repository.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class DeleteUserDomainService implements DomainService<Void> {
    private String code;
    private List<String> ids;
    public DeleteUserDomainService(String code, List<String> ids){
        this.code = code;
        this.ids = ids;
    }
    @Override
    @Transactional
    public Void execute(ApplicationContext context) {
        List<OrgEntity> orgEntities = context.getBean(OrgMapper.class).selectList(new QueryWrapper<OrgEntity>().likeRight("code", code));
        context.getBean(OrgUserMapper.class).delete(new QueryWrapper<OrgUserEntity>().in("org_id", orgEntities.stream().map(OrgEntity::getId).collect(Collectors.toList())).in("user_id", ids));
        context.getBean(UserMapper.class).deleteBatchIds(ids);
        return null;
    }
}
