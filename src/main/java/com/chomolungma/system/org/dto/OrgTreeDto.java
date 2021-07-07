package com.chomolungma.system.org.dto;

import com.chomolungma.system.common.tree.annotation.Children;
import com.chomolungma.system.common.tree.annotation.Id;
import com.chomolungma.system.common.tree.annotation.Pid;
import lombok.Data;

import java.util.List;

@Data
public class OrgTreeDto {
    @Id
    private Long id;
    @Pid
    private Long pid;
    private String name;
    private String manager;
    private String tel;
    private String order;
    private String status;
    @Children
    private List<OrgTreeDto> children;
}
