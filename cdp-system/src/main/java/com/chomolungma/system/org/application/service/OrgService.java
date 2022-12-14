package com.chomolungma.system.org.application.service;

import com.chomolungma.system.org.interfaces.param.OrgParam;

public interface OrgService {
    void createOrg(OrgParam orgEntity);

    void updateOrg(OrgParam orgParam);

    void deleteOrg(Long code);
}
