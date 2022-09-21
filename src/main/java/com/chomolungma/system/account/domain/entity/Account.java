package com.chomolungma.system.account.domain.entity;

import com.chomolungma.core.domain.entity.BaseEntity;
import lombok.Data;

import java.util.List;


@Data
public class Account extends BaseEntity {
    private Long userId;
    private String username;
//    private List<Long> roleIds;
//    private String roleName;
    private String password;
    private String name;
    private String nickname;
    private String avatar;
    private List<Role> roles;

    public void resetPassword(){
        this.password = "123456";
    }

    public void bindUser(Long userId){
        this.userId = userId;
    }

}
