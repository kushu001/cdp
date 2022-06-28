package com.chomolungma.system.account.entity;

import com.chomolungma.core.domain.entity.BaseEntity;
import lombok.Data;

import java.util.List;


@Data
public class AccountEntity extends BaseEntity {
    private Long userId;
    private String username;
    private List<Long> roleIds;
    private String roleName;
    private String password;
    private String name;
    private String nickname;
    private String avatar;

    public void resetPassword(){
        this.password = "123456";
    }

    public void bindUser(Long userId){
        this.userId = userId;
    }

}
