package com.chomolungma.system.org.application.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.interfaces.param.OrgParam;

import java.util.List;

public interface OrgService {

    IPage<OrgEntity> queryOrg(Page<OrgEntity> page, OrgEntity org);


    List<OrgEntity> query(OrgEntity org);


    void createOrg(OrgParam orgEntity);

    void updateOrg(OrgParam orgParam);

    void deleteOrg(Long code);
}
