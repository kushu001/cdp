package com.chomolungma.cdp.tree;

import java.util.List;

public class Node<T> {
    private List<T> children;

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
