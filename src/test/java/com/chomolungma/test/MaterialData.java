package com.chomolungma.test;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class MaterialData {
    @ExcelProperty(index = 0)
    private String code;
}
