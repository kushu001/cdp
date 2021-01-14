package com.chomolungma.common.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.Instant;

@Data
@JsonInclude(value= JsonInclude.Include.NON_NULL)
public class BaseVo {
    private Long id;
    private Instant createTime;
    private Instant updateTime;
    private Long createUser;
    private Long updateUser;
}
