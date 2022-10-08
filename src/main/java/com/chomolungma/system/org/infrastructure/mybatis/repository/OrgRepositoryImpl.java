package com.chomolungma.system.org.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.domain.repository.IOrgRepository;
import com.chomolungma.system.org.infrastructure.converter.OrgConverter;
import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import com.chomolungma.system.org.infrastructure.mybatis.repository.mapper.OrgMapper;
import com.chomolungma.system.org.interfaces.dto.OrgDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrgRepositoryImpl implements IOrgRepository {
    private final OrgMapper orgMapper;

    public OrgRepositoryImpl(OrgMapper orgMapper) {
        this.orgMapper = orgMapper;
    }

    @Override
    public OrgEntity findOne(Long id) {
        OrgDO orgDo = orgMapper.selectById(id);
        return OrgConverter.INSTANCE.toEntity(orgDo);
    }

    @Override
    public List<OrgEntity> find(OrgDTO orgDTO) {
        List<OrgDO> orgDOS = orgMapper.selectVo(OrgConverter.INSTANCE.toDO(orgDTO));
        return OrgConverter.INSTANCE.toEntity(orgDOS);
    }

    @Override
    public void save(OrgEntity org) {
        OrgDO orgDO = OrgConverter.INSTANCE.toDO(org);
        if (orgDO.getId() == null) {
            orgMapper.insert(orgDO);
        }else {
            orgMapper.updateById(orgDO);
        }
    }

    @Override
    public void remove(Long id) {
        OrgDO orgDO = orgMapper.selectById(id);
        orgMapper.delete(new QueryWrapper<OrgDO>().likeRight("code", orgDO.getCode()));
    }
}
