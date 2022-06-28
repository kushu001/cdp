package com.chomolungma.system.dict.interfaces.param;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

@Data
public class DictParam extends PageDTO {
    private String name;
    private String code;
    private String desc;
    private Integer sort;
    private String param;
}
