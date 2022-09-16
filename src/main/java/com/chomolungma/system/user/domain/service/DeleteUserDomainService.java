package com.chomolungma.system.user.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.core.domain.service.DomainService;
import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import com.chomolungma.system.org.infrastructure.mybatis.repository.mapper.OrgMapper;
import com.chomolungma.system.user.infrastructure.dataobject.OrgUserDO;
import com.chomolungma.system.user.infrastructure.mybatis.repository.mapper.OrgUserMapper;
import com.chomolungma.system.user.infrastructure.mybatis.repository.mapper.UserMapper;
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
        List<OrgDO> orgDOS = context.getBean(OrgMapper.class).selectList(new QueryWrapper<OrgDO>().likeRight("code", code));
        context.getBean(OrgUserMapper.class).delete(new QueryWrapper<OrgUserDO>().in("org_id", orgDOS.stream().map(OrgDO::getId).collect(Collectors.toList())).in("user_id", ids));
        context.getBean(UserMapper.class).deleteBatchIds(ids);
        return null;
    }
}
