package com.chomolungma.dict.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.common.pojo.BaseBean;
import lombok.Data;

@Data
@TableName("sys_dict")
public class Dict extends BaseBean {
    private String name;
    private String code;
    @TableField("`desc`")
    private String desc;
    private Integer sorter;
    private Boolean status;
}
