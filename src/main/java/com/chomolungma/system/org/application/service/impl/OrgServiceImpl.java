package com.chomolungma.system.org.application.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.org.application.service.OrgService;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import com.chomolungma.system.org.infrastructure.mybatis.repository.mapper.OrgMapper;
import com.chomolungma.system.org.interfaces.mapstruct.OrgEntityMapStruct;
import com.chomolungma.system.org.interfaces.param.OrgParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgServiceImpl implements OrgService {

    private OrgMapper orgMapper;

    public OrgServiceImpl(OrgMapper orgMapper){
        this.orgMapper = orgMapper;
    }

    @Override
    public IPage<OrgEntity> queryOrg(Page<OrgEntity> page, OrgEntity org) {
        // orgMapper.selectPageVo(page,org);
        return null;
    }

    @Override
    public List<OrgEntity> query(OrgEntity org) {
        return null; //orgMapper.selectVo(org);
    }

    @Override
    public void createOrg(OrgParam orgParam) {
        OrgDO currentMaxOrg = orgMapper.selectOne(new QueryWrapper<OrgDO>().eq("pid",orgParam.getPid()).orderByDesc("code").last("limit 1"));
        int num = 1;
        if (currentMaxOrg != null) {
            num = Integer.parseInt(currentMaxOrg.getCode().substring(currentMaxOrg.getCode().length()-3)) + 1;
        }
        OrgDO parent = orgMapper.selectById(orgParam.getPid());
        String parentCode  = parent == null ? "" : parent.getCode();
        orgParam.setCode(parentCode + String.format("%03d", num));
        orgMapper.insert(OrgEntityMapStruct.INSTANCE.toDO(orgParam));
    }


    @Override
    public void updateOrg(OrgParam orgParam) {
        OrgDO orgDO = new OrgDO();
        orgDO.setCode(orgParam.getCode());
        orgDO.setName(orgParam.getName());
        orgDO.setManagerId(orgParam.getManagerId());
        orgMapper.updateById(orgDO);
    }

    @Override
    public void deleteOrg(Long id) {
        OrgDO orgDO = orgMapper.selectById(id);
        orgMapper.delete(new QueryWrapper<OrgDO>().likeRight("code", orgDO.getCode()));
    }
}
