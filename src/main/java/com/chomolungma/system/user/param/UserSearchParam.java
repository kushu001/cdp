package com.chomolungma.system.user.param;

import com.chomolungma.system.common.param.PageParam;
import lombok.Data;

@Data
public class UserSearchParam extends PageParam {

    private String name;
    private String gender;
    private String tel;
    private String addr;
    private String company;
    private String status;
}
