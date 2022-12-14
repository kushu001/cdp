package com.chomolungma.system.account.infrastructure.dataobject;

import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
public class AccountUserRoleDO extends BaseDO {
    private String username;
    private String nickname;
    private String name;
    private String roleName;
    private String avatar;
    private Boolean enabled;
}
