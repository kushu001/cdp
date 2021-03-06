package com.chomolungma.menu.dto;

import com.chomolungma.common.tree.annotation.Children;
import com.chomolungma.common.tree.annotation.Id;
import com.chomolungma.common.tree.annotation.Pid;
import lombok.Data;

import java.util.List;

@Data
public class MenuTreeDto {
    @Id
    private Long id;
    @Pid
    private Long pid;
    private String name;
    private String url;
    private String icon;
    private String order;
    private String status;
    @Children
    private List<MenuTreeDto> children;
}
