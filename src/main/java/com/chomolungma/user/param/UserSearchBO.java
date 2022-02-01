package com.chomolungma.user.param;

import com.chomolungma.common.param.PageBO;
import lombok.Data;

@Data
public class UserSearchBO extends PageBO {

    private String name;
    private String gender;
    private String tel;
    private String addr;
    private String company;
    private String status;
}
