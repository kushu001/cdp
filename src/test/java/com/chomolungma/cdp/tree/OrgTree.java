package com.chomolungma.cdp.tree;


import com.chomolungma.cdp.tree.annotation.Children;
import com.chomolungma.cdp.tree.annotation.Id;
import com.chomolungma.cdp.tree.annotation.Node;
import com.chomolungma.cdp.tree.annotation.Pid;

import java.util.List;

@Node
public class OrgTree{

    @Id
    private Long id;

    @Pid
    private Long pid;

    private String name;

    @Children
    private List<OrgTree> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrgTree> getChildren() {
        return children;
    }

    public void setChildren(List<OrgTree> children) {
        this.children = children;
    }
}
