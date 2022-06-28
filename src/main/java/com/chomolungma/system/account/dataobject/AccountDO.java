package com.chomolungma.system.account.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
@TableName("sys_account")
public class AccountDO extends BaseDO {
    private String username;
    private Long userId;
    private String nickname;
    private String password;
    private String avatar;
}
