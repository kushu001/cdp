package com.chomolungma.system.log.interfaces.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

import java.util.List;

@Data
public class LoginLogPageDTO extends PageDTO {
    private List<LoginLogDTO> records;
}
