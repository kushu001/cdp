package com.chomolungma.system.org.application.service.impl;

import com.chomolungma.system.org.application.service.OrgService;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.domain.factory.OrgFactory;
import com.chomolungma.system.org.domain.repository.IOrgRepository;
import com.chomolungma.system.org.interfaces.param.OrgParam;
import org.springframework.stereotype.Service;

@Service
public class OrgServiceImpl implements OrgService {

    private final OrgFactory orgFactory;

    private final IOrgRepository iOrgRepository;

    public OrgServiceImpl(OrgFactory orgFactory, IOrgRepository iOrgRepository){
        this.orgFactory = orgFactory;
        this.iOrgRepository = iOrgRepository;
    }

    @Override
    public void createOrg(OrgParam orgParam) {
        OrgEntity org = orgFactory.createOrg(orgParam);
        iOrgRepository.save(org);
    }


    @Override
    public void updateOrg(OrgParam orgParam) {
        OrgEntity org = orgFactory.createOrg(orgParam);
        iOrgRepository.save(org);
    }

    @Override
    public void deleteOrg(Long id) {
        iOrgRepository.remove(id);
    }
}
