package com.chomolungma.system.staff.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@TableName(value = "sys_org_user")
@Data
public class OrgStaffDO extends BaseDO {
    private Long orgId;
    private String orgName;
    private Long userId;
    private String userName;
}
