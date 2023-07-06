package com.chomolungma.system.resource.interfaces.dto;

import com.chomolungma.core.dto.BaseDTO;
import lombok.Data;

@Data
public class ResourceDTO extends BaseDTO {
    private String name;
    private String sign;
    private String url;
    private String method;
}
