package com.chomolungma.dict.param;

import lombok.Data;

@Data
public class DictItemParam{
    private Long id;
    private Long dictId;
    private String name;
    private String code;
    private String desc;
    private Integer sorter;
    private Boolean status;
}
