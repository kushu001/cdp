package com.chomolungma.system.user.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.mapper.OrgMapper;
import com.chomolungma.system.user.domain.entity.OrgUserEntity;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.domain.repository.mapper.OrgUserMapper;
import com.chomolungma.system.user.domain.repository.mapper.UserMapper;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.stream.Collectors;

public class PageUsersDomainService implements DomainService<Page<UserEntity>> {
    private Page<UserEntity> page;
    private UserEntity user;
    private String code;
    public PageUsersDomainService(String code, Page<UserEntity> page, UserEntity user){
        this.code = code;
        this.page = page;
        this.user = user;
    }

    @Override
    public Page<UserEntity> execute(ApplicationContext context) {
        List<OrgEntity> orgs = context.getBean(OrgMapper.class).selectList(new QueryWrapper<OrgEntity>().likeRight("code", code));
        List<OrgUserEntity> orgUserEntities = context.getBean(OrgUserMapper.class).selectList(new QueryWrapper<OrgUserEntity>().in("org_id", orgs.stream().map(OrgEntity::getId).collect(Collectors.toList())));
        UserMapper userMapper =context.getBean(UserMapper.class);
        List<Long> userIds = orgUserEntities.stream().map(OrgUserEntity::getUserId).collect(Collectors.toList());
        return userIds.size()==0? page:userMapper.selectPage(page, new QueryWrapper<UserEntity>().like(user.getName() !=null,"name",user.getName()).in("id", userIds));
    }
}
