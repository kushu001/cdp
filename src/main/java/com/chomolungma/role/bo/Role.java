package com.chomolungma.role.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private String id;
    private String name;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
