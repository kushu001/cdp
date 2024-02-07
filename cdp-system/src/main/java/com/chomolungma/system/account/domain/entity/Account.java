package com.chomolungma.system.account.domain.entity;

import com.chomolungma.core.entity.BaseEntity;
import lombok.Data;

import java.util.List;


@Data
public class Account extends BaseEntity {
    private Long userId;
    private String username;
    private String password;
    private String name;
    private String nickname;
    private String avatar;
    private String type;
    private List<Role> roles;
    private Boolean enabled;

    public void resetPassword(){
        this.password = "$2a$10$T7rdEA1tYiC9WndRG7PBPuYZvTNRIzcIq9UYU/cCI/8n5DRkqRBvG";
    }

    public void bindUser(Long userId){
        this.userId = userId;
    }

}
