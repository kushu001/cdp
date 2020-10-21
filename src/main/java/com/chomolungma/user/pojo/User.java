package com.chomolungma.user.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class User {
    private Long id;
    private String name;
    private String gender;
    private String tel;
    private String addr;
    private String company;
    private String status;
}
