package com.chomolungma.system.post.interfaces.param;

import com.chomolungma.core.interfaces.dto.PageDTO;
import lombok.Data;

@Data
public class PostPageParam extends PageDTO {
    private String name;
    private String code;
    private String type;
    private Integer sort;
}
