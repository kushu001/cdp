package com.chomolungma.system.org.domain.repository;

import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.interfaces.dto.OrgDTO;

import java.util.List;

public interface IOrgRepository {
    OrgEntity findOne(Long id);
    List<OrgEntity> find(OrgDTO orgDTO);
}
