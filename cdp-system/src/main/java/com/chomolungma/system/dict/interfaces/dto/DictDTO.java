package com.chomolungma.system.dict.interfaces.dto;


import com.chomolungma.core.dto.BaseDTO;
import lombok.Data;

@Data
public class DictDTO extends BaseDTO {
    private String code;
    private String name;
    private String sort;
}
