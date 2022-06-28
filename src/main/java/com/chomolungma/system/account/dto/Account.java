package com.chomolungma.system.account.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Account {
    private Long id;
    private String username;
    private String name;
    private String nickname;
    private String roleName;
    private List<Long> roleIds;
    private String avatar;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
}
