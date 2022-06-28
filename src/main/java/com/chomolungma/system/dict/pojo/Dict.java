package com.chomolungma.system.dict.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.common.entity.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
@TableName("sys_dict")
public class Dict extends BaseEntity {
    private String name;
    private String code;
    @TableField("`desc`")
    private String desc;
    private Integer sorter;
    private Boolean status;

    private List<DictItem> children;
}
