package com.chomolungma.app;

import java.util.List;

public class TreeNode<T> {

    /**
     * 本节点
     */
    private T node;

    /**
     * 子结点
     */
    private List<TreeNode<T>> children;

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }
}
