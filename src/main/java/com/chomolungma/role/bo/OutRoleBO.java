package com.chomolungma.role.bo;

import com.chomolungma.common.param.PageBO;
import lombok.Data;

import java.util.List;

@Data
public class OutRoleBO extends PageBO {
    private List<Role> records;
}
