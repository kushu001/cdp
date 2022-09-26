package com.chomolungma.system.role.infrastructure.dataobject;

import com.chomolungma.system.role.interfaces.dto.RoleMenuDTO;
import lombok.Data;

import java.util.List;
@Data
public class RolePermissionDO {
    private Long roleId;
    private List<RoleMenuDTO> permissions;
}
