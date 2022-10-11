package com.chomolungma.system.role.infrastructure.dataobject;

import lombok.Data;

import java.util.List;
@Data
public class RolePermissionDO {
    private Long roleId;
    private List<Long> permissions;
}
