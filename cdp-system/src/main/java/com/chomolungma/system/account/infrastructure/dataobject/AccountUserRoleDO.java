package com.chomolungma.system.account.infrastructure.dataobject;

import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

import java.util.List;

@Data
public class AccountUserRoleDO extends BaseDO {
    private String username;
    private String nickname;
    private String name;
    private String roleName;
    private List<Long> roleIds;
    private String avatar;
    private Boolean enabled;
}
