package com.chomolungma.system.post.interfaces.dto;

import com.chomolungma.core.dto.BaseDTO;
import lombok.Data;

@Data
public class PostDTO extends BaseDTO {
    private String name;
    private String code;
    private String type;
    private String typeName;
    private Integer sort;
}
