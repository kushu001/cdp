package com.chomolungma.system.role.interfaces.dto;

import lombok.Data;

import java.util.List;

@Data
public class InPermissionDTO {
    private List<Long> permissions;
}
