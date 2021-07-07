package com.chomolungma.system.menu.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.system.common.pojo.BaseBean;
import lombok.Data;

@Data
@TableName("sys_menu")
public class Menu extends BaseBean {

    private Long pid;
    private String name;
    private String url;
    private String icon;
    @TableField("`order`")
    private Integer order;
    private String status;
}
