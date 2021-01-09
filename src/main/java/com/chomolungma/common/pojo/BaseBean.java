package com.chomolungma.common.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class BaseBean {

    @TableId(type = IdType.AUTO)
    private Long id;
}
