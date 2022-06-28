package com.chomolungma.system.org.interfaces.dto;

import com.chomolungma.core.interfaces.dto.BaseDTO;
import lombok.Data;

@Data
public class OrgDTO extends BaseDTO {
    private Long pid;
    private String name;
    private String code;
    private String manager;
    private String managerId;
    private String tel;
    private String order;
}
