package com.chomolungma.system.staff.infrastructure.adapter;

import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.domain.repository.IOrgRepository;
import com.chomolungma.system.staff.domain.entity.Org;
import org.springframework.stereotype.Component;

@Component
public class OrgAdapter {
    private final IOrgRepository iOrgRepository;
    public OrgAdapter(IOrgRepository iOrgRepository) {
        this.iOrgRepository = iOrgRepository;
    }
    public Org adapter(Long orgId){
        OrgEntity org  = iOrgRepository.findOne(orgId);
        Org userOrg = new Org();
        userOrg.setId(org.getId());
        userOrg.setName(org.getName());

        return userOrg;
    }
}
