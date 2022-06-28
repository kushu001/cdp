package com.chomolungma.system.post.repository.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
@TableName("sys_post")
public class PostDO extends BaseDO {
    private String name;
    private String code;
    private String type;
    private Integer sort;
}
