package com.chomolungma.role.enity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_role")
public class RoleEntity {
    @TableId
    public Long id;
    public String name;
    public String status;
    public Date createTime;
}
