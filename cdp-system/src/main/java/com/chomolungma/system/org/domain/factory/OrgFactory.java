package com.chomolungma.system.org.domain.factory;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.infrastructure.dataobject.OrgDO;
import com.chomolungma.system.org.infrastructure.mybatis.repository.mapper.OrgMapper;
import com.chomolungma.system.org.interfaces.mapstruct.OrgEntityMapStruct;
import com.chomolungma.system.org.interfaces.param.OrgParam;
import org.springframework.stereotype.Component;

@Component
public class OrgFactory {
    private final OrgMapper orgMapper;

    public OrgFactory(OrgMapper orgMapper){
        this.orgMapper = orgMapper;
    }

    public OrgEntity createOrg(OrgParam orgParam){
        if (orgParam.getId() == null) {
            OrgDO currentMaxOrg = orgMapper.selectOne(new QueryWrapper<OrgDO>().eq("pid",orgParam.getPid()).orderByDesc("code").last("limit 1"));
            int num = 1;
            if (currentMaxOrg != null) {
                num = Integer.parseInt(currentMaxOrg.getCode().substring(currentMaxOrg.getCode().length()-3)) + 1;
            }
            OrgDO parent = orgMapper.selectById(orgParam.getPid());
            String parentCode  = parent == null ? "" : parent.getCode();
            orgParam.setCode(parentCode + String.format("%03d", num));
        }
        return OrgEntityMapStruct.INSTANCE.toEntity(orgParam);
    }
}
