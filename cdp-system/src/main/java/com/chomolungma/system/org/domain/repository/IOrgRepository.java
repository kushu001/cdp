package com.chomolungma.system.org.domain.repository;

import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.interfaces.dto.OrgDTO;

import java.util.List;

public interface IOrgRepository {
    OrgEntity find(Long id);
    List<OrgEntity> find(OrgDTO orgDTO);
    void save(OrgEntity org);
    void remove(Long id);
}
