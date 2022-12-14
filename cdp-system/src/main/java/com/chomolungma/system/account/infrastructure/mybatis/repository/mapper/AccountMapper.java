package com.chomolungma.system.account.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.account.infrastructure.dataobject.AccountDO;
import com.chomolungma.system.account.domain.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface AccountMapper extends BaseMapper<AccountDO> {
    List<Role> selectRolesByAccountId(Long accountId);
    List<String> getPermissions(Long accountId);
    List<String> getResources(Long accountId);
    void deleteBatchByIds(List<String> ids);
}
