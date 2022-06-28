package com.chomolungma.system.account.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

import java.util.List;

@Data
public class AccountPageDTO extends PageDTO {
    private List<Account> records;
}
