package com.chomolungma.system.org.application.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.org.application.service.OrgService;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.mapper.OrgMapper;
import com.chomolungma.system.org.pojo.Org;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

    private OrgMapper orgMapper;

    public OrgServiceImpl(OrgMapper orgMapper){
        this.orgMapper = orgMapper;
    }

    @Override
    public IPage<Org> queryOrg(Page<Org> page, Org org) {
        // orgMapper.selectPageVo(page,org);
        return null;
    }

    @Override
    public List<Org> query(Org org) {
        return null; //orgMapper.selectVo(org);
    }

    @Override
    public void createOrg(OrgEntity orgEntity) {
        OrgEntity currentMaxOrg = orgMapper.selectOne(new QueryWrapper<OrgEntity>().eq("pid",orgEntity.getPid()).orderByDesc("code").last("limit 1"));
        int num = 1;
        if (currentMaxOrg != null) {
            num = Integer.parseInt(currentMaxOrg.getCode().substring(currentMaxOrg.getCode().length()-3)) + 1;
        }
        OrgEntity parent = orgMapper.selectById(orgEntity.getPid());
        String parentCode  = parent == null ? "" : parent.getCode();
        orgEntity.setCode(parentCode + String.format("%03d", num));
        orgMapper.insert(orgEntity);
    }


    @Override
    public void updateOrg(OrgEntity orgEntity) {
        orgMapper.updateById(orgEntity);
    }

    @Override
    public void deleteOrg(Long id) {
        OrgEntity orgEntity = orgMapper.selectById(id);
        orgMapper.delete(new QueryWrapper<OrgEntity>().likeRight("code", orgEntity.getCode()));
    }
}
