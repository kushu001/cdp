package com.chomolungma.system.dict.interfaces.dto;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

import java.util.List;

@Data
public class DictItemPageDTO extends PageDTO {
    private List<DictItemDTO> records;
}
