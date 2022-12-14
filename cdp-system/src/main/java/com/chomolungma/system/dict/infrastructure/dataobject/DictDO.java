package com.chomolungma.system.dict.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@TableName("sys_dict")
@Data
public class DictDO extends BaseDO {
    private String name;
    private String code;
//    @TableField("`desc`")
//    private String desc;
    private Integer sort;
}
