package com.chomolungma.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.Instant;

@Data
public class BaseEntity {

    private Long id;

    private Instant createTime;

    private Instant updateTime;

    private Long createUser;

    private Long updateUser;

}
