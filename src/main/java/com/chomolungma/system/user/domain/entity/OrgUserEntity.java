package com.chomolungma.system.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.domain.entity.BaseEntity;
import lombok.Data;

@TableName("sys_org_user")
@Data
public class OrgUserEntity extends BaseEntity {
    private Long orgId;
    private Long userId;
}
