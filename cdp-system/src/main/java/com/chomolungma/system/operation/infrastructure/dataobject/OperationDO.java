package com.chomolungma.system.operation.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chomolungma.core.dataobject.BaseDO;
import java.lang.String;
import lombok.Data;

/**
*  Automatically generated code by CDP-GENERATOR maven-plugin.
*  Thank you for your use.
*  Good Luck!
*/

@Data
@TableName("sys_operation")
public class OperationDO extends BaseDO {
    // 按钮名称
    private String name;
    // 编码
    private String code;
    // 组件路径
    private String path;
    // 所属分组
    private String group;
    // 级别（1. 系统级 2. 页面级）
    private String level;
}
