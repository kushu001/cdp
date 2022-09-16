package com.chomolungma.system.user.infrastructure.adapter;

import com.chomolungma.system.org.domain.repository.IOrgRepository;
import com.chomolungma.system.user.domain.entity.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrgAdapter {
    @Autowired
    private IOrgRepository orgRepository;

    public Org adapter(Long orgId){
        com.chomolungma.system.org.pojo.Org org  = orgRepository.find(orgId);
        Org userOrg = new Org();
        userOrg.setId(org.getId());
        userOrg.setName(org.getName());

        return userOrg;
    }
}
