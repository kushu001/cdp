package com.chomolungma.system.org.infrastructure.mybatis.repository;

import com.chomolungma.system.org.domain.repository.IOrgRepository;
import com.chomolungma.system.org.infrastructure.converter.OrgConverter;
import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import com.chomolungma.system.org.infrastructure.mybatis.repository.mapper.OrgMapper;
import com.chomolungma.system.org.pojo.Org;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrgRepositoryImpl implements IOrgRepository {
    @Autowired
    private OrgMapper orgMapper;
    @Override
    public Org find(Long id) {
        OrgDO orgDo = orgMapper.selectById(id);
        return OrgConverter.INSTANCE.toEntity(orgDo);
    }
}
