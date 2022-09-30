package com.chomolungma.system.dict.interfaces.param;

import com.chomolungma.core.interfaces.dto.PageDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DictParam extends PageDTO {
    private String name;
    private String code;
    private String desc;
    private Integer sort;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private String param;
}
