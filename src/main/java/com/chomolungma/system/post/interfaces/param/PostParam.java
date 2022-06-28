package com.chomolungma.system.post.interfaces.param;

import lombok.Data;

@Data
public class PostParam {
    private Long id;
    private String name;
    private String code;
    private String type;
    private Integer sort;
}
