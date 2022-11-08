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
    private Boolean enabled;

    public void resetPassword(){
        this.password = "$2a$10$G8C2EAQk7audou2Niau8luZnNUin6DR1eVGhRpQ5Dmo.Ke1cpxMhK";
    }

    public void bindUser(Long userId){
        this.userId = userId;
    }

}
