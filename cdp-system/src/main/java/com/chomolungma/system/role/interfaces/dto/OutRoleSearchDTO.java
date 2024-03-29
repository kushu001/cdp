package com.chomolungma.system.role.interfaces.dto;

import com.chomolungma.core.dto.PageDTO;
import lombok.Data;

import java.util.List;

@Data
public class OutRoleSearchDTO extends PageDTO {
    private List<RoleDTO> records;
}
