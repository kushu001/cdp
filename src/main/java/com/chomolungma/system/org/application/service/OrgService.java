package com.chomolungma.system.org.application.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.pojo.Org;

import java.util.List;

public interface OrgService {

    IPage<Org> queryOrg(Page<Org> page, Org org);


    List<Org> query(Org org);


    void createOrg(OrgEntity orgEntity);

    void updateOrg(OrgEntity orgEntity);

    void deleteOrg(Long code);
}
