package com.chomolungma.system.account.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

@Data
public class AccountDTO extends PageDTO {
    private String username;
    private String name;
    private String nickname;
    private String avatar;
}
