package com.chomolungma.system.dict.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.domain.entity.BaseEntity;
import lombok.Data;

@Data
@TableName("sys_dict")
public class DictEntity extends BaseEntity {
    private String code;
    private String name;
    private String sort;
}
