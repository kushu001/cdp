package com.chomolungma.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("sys_account")
@Data
public class AccountEntity {
    private Long id;
    private String username;
    private String password;
}
