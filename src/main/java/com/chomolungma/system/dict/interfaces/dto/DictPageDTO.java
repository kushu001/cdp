package com.chomolungma.system.dict.interfaces.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

import java.util.List;

@Data
public class DictPageDTO extends PageDTO {
    private List<DictDTO> records;
}
