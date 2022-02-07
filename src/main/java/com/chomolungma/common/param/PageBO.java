package com.chomolungma.common.param;

import lombok.Data;

@Data
public class PageBO extends BaseBO {
    private Integer limit;
    private Long page;
    private Long total;
}
