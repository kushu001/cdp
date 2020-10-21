package com.chomolungma.common.param;

import lombok.Data;

@Data
public class PageParam {
    private Integer pageSize;
    private Integer current;
}
