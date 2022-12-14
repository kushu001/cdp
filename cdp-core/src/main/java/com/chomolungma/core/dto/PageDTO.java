package com.chomolungma.core.dto;

import lombok.Data;

@Data
public class PageDTO extends BaseDTO{
    private Integer limit;
    private Integer page;
    private Long total;
}
