package com.chomolungma.system.account.infrastructure.dto;

import lombok.Data;

@Data
public class RoleDTO {
    private Long id;
    private String name;
    private String code;
    private String remark;
}
