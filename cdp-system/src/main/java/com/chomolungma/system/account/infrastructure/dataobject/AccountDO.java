package com.chomolungma.system.account.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
@TableName("sys_account")
public class AccountDO extends BaseDO {
    private String username;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long userId;
    private String nickname;
    private String password;
    private String avatar;
    private Boolean enabled;
}
