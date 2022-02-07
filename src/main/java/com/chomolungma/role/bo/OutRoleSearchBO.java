package com.chomolungma.role.bo;

import com.chomolungma.common.param.PageBO;
import lombok.Data;

import java.util.List;

@Data
public class OutRoleSearchBO extends PageBO {
    private List<Role> records;
}
