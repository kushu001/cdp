package com.chomolungma.dict.param;

import lombok.Data;

@Data
public class DictParam {
    private Long id;
    private String name;
    private String code;
    private String desc;
    private Integer sorter;
    private Integer status;
}
