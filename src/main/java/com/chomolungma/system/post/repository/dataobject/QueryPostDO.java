package com.chomolungma.system.post.repository.dataobject;

import com.chomolungma.core.dataobject.BaseDO;
import lombok.Data;

@Data
public class QueryPostDO extends BaseDO {
    private String name;
    private String code;
    private String type;
    private String typeName;
    private Integer sort;
}
