package com.chomolungma.dict.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.common.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("sys_dict_item")
public class DictItem extends BaseEntity {
    private Long dictId;
    private String name;
    private String code;
    @TableField("`desc`")
    private String desc;
    private Integer sorter;
    private Integer status;





}
