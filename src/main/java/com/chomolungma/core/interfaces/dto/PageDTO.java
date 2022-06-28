package com.chomolungma.core.interfaces.dto;

import lombok.Data;

@Data
public class PageDTO {
    private Integer limit;
    private Long page;
    private Long total;
}
