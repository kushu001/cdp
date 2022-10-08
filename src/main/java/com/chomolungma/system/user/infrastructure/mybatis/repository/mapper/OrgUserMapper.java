package com.chomolungma.system.user.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.user.infrastructure.dataobject.OrgUserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrgUserMapper extends BaseMapper<OrgUserDO> {
}
