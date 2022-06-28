package com.chomolungma.system.account.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
@TableName("sys_account_role")
public class AccountRoleDO extends BaseDO {
    private Long accountId;
    private Long roleId;
}
