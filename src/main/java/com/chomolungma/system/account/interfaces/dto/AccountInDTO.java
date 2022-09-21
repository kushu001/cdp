package com.chomolungma.system.account.interfaces.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountInDTO {
    private Long id;
    private Long userId;
    private List<Long> roleIds;
    private String username;
    private String nickname;
    private String avatar;
    private Integer status;
}
