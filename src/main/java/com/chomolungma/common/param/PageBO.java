package com.chomolungma.common.param;

import lombok.Data;

@Data
public class PageBO {
    private Integer limit;
    private Long page;
    private Long total;
}
