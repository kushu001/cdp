package com.chomolungma.system.account.interfaces.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

import java.util.List;

@Data
public class AccountDTO extends PageDTO {
    private Long userId;
    private String username;
    private List<Long> roleIds;
    private List<String> permissions;
    private List<String> resources;
    private String roleName;
    private String password;
    private String name;
    private String nickname;
    private String avatar;
    private Boolean enabled;
}
