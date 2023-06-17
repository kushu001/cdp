package com.chomolungma.system.operation.domain.entity;

import com.chomolungma.core.entity.BaseEntity;
import java.lang.String;
import lombok.Data;

/**
*  Automatically generated code by CDP-GENERATOR maven-plugin.
*  Thank you for your use.
*  Good Luck!
*/

@Data
public class Operation extends BaseEntity {
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
