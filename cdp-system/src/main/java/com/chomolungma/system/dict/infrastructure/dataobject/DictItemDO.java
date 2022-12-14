package com.chomolungma.system.dict.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@TableName("sys_dict_item")
@Data
public class DictItemDO extends BaseDO {
    private Long dictId;
    private String name;
    private String value;
    private String code;
    private Integer sort;
}
