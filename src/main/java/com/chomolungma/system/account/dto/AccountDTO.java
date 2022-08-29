package com.chomolungma.system.account.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

import java.util.List;

@Data
public class AccountDTO extends PageDTO {
    private Long userId;
    private String username;
    private List<Long> roleIds;
    private String roleName;
    private String password;
    private String name;
    private String nickname;
    private String avatar;
}
