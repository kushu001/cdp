package com.chomolungma.system.dict.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.domain.entity.BaseEntity;
import lombok.Data;

@TableName("sys_dict_item")
@Data
public class DictItemEntity extends BaseEntity {
    private Long dictId;
    private String code;
    private String name;
    private String value;
    private Integer sort;
}
