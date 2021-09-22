package com.chomolungma.system.org.application.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.infrastructure.ApplicationService;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.domain.service.SaveDomainService;
import com.chomolungma.system.org.mapper.OrgMapper;
import com.chomolungma.system.org.application.service.OrgService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrgServiceImpl extends ApplicationService implements OrgService {

    private OrgMapper orgMapper;

    public OrgServiceImpl(OrgMapper orgMapper){
        this.orgMapper = orgMapper;
    }

    @Override
    public IPage<OrgEntity> queryOrg(Page<OrgEntity> page, OrgEntity orgEntity) {
        return orgMapper.selectPageVo(page, orgEntity);
    }

    @Override
    public List<OrgEntity> query(OrgEntity orgEntity) {
        return orgMapper.selectVo(orgEntity);
    }

    @Override
    public void createOrg(OrgEntity orgEntity) {
        this.domainServiceInvoker.invoke(new SaveDomainService(orgEntity));
    }


    @Override
    public void updateOrg(OrgEntity orgEntity) {
        orgMapper.updateById(orgEntity);
    }

    @Override
    public void deleteOrg(String ids) {
        orgMapper.deleteBatchIds(Arrays.asList(ids.split(",")));
    }
}
