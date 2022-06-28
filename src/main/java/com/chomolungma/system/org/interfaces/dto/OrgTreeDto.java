package com.chomolungma.system.org.interfaces.dto;

import com.chomolungma.common.tree.annotation.Children;
import com.chomolungma.common.tree.annotation.Id;
import com.chomolungma.common.tree.annotation.Pid;
import lombok.Data;

import java.util.List;

@Data
public class OrgTreeDto {
    @Id
    private Long id;
    @Pid
    private Long pid;
    private String name;
    private String code;
    private String manager;
    private String tel;
    private String order;
    private String status;
    @Children
    private List<OrgTreeDto> children;
}
