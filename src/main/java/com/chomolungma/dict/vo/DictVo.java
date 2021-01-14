package com.chomolungma.dict.vo;

import com.chomolungma.common.vo.BaseVo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class DictVo extends BaseVo {
    private String title;
    private Long key;
    private String name;
    private String code;
    private String desc;
    private Integer sorter;
    private Integer status;
    @JsonProperty("isLeaf")
    private Boolean isLeaf;
    private DictVo parent;
    private List<DictVo> children;
}
