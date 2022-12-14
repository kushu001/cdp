package com.chomolungma.system.dict.interfaces.param;

import com.chomolungma.core.dto.PageDTO;
import lombok.Data;

@Data
public class DictItemParam extends PageDTO {
    private Long id;
    private Long dictId;
    private String name;
    private String code;
    private String value;
    private String desc;
    private Integer sort;
    private Integer status;
}
