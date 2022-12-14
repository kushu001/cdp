package com.chomolungma.system.account.interfaces.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class AccountExcelDTO{
    @ExcelProperty("账号")
    private String username;
    @ExcelProperty("用户名")
    private String name;
    @ExcelProperty("昵称")
    private String nickname;
    @ExcelProperty("头像")
    private String avatar;
}
