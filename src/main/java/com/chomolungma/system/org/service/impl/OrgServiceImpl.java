package com.chomolungma.system.org.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.org.mapper.OrgMapper;
import com.chomolungma.system.org.pojo.Org;
import com.chomolungma.system.org.service.OrgService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

    private OrgMapper orgMapper;

    public OrgServiceImpl(OrgMapper orgMapper){
        this.orgMapper = orgMapper;
    }

    @Override
    public IPage<Org> queryOrg(Page<Org> page, Org org) {
        return orgMapper.selectPageVo(page,org);
    }

    @Override
    public List<Org> query(Org org) {
        return orgMapper.selectVo(org);
    }

    @Override
    public void createOrg(Org org) {
        orgMapper.insert(org);
    }


    @Override
    public void updateOrg(Org org) {
        orgMapper.updateById(org);
    }

    @Override
    public void deleteOrg(String ids) {
        orgMapper.deleteBatchIds(Arrays.asList(ids.split(",")));
    }
}
