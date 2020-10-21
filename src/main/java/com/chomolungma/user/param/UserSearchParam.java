package com.chomolungma.user.param;

import com.chomolungma.common.param.PageParam;
import lombok.Data;

@Data
public class UserSearchParam extends PageParam {

    private String name;
    private String gender;
}
