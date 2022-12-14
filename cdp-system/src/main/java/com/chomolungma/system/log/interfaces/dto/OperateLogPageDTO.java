package com.chomolungma.system.log.interfaces.dto;

import com.chomolungma.core.dto.PageDTO;
import lombok.Data;

import java.util.List;

@Data
public class OperateLogPageDTO extends PageDTO {
    private List<OperateLogDTO> records;
}
