package com.chomolungma.system.org.application.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.org.domain.entity.OrgEntity;

import java.util.List;

public interface OrgService {

    IPage<OrgEntity> queryOrg(Page<OrgEntity> page, OrgEntity orgEntity);


    List<OrgEntity> query(OrgEntity orgEntity);


    void createOrg(OrgEntity orgEntity);

    void updateOrg(OrgEntity orgEntity);

    void deleteOrg(String ids);
}
