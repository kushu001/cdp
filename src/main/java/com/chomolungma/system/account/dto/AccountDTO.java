package com.chomolungma.system.account.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

@Data
public class AccountDTO extends PageDTO {
    @ExcelProperty("账号")
    private String username;
    @ExcelProperty("用户名")
    private String name;
    @ExcelProperty("昵称")
    private String nickname;
    private String avatar;
}
