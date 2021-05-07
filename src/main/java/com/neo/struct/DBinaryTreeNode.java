package com.neo.struct;

import java.util.Objects;

public class DBinaryTreeNode {

    public DBinaryTreeNode(int value) {
        this.value = value;
    }

    public int value;

    public DBinaryTreeNode left;

    public DBinaryTreeNode right;

    public DBinaryTreeNode parent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DBinaryTreeNode that = (DBinaryTreeNode) o;
        return value == that.value &&
                Objects.equals(left, that.left) &&
                Objects.equals(right, that.right) &&
                Objects.equals(parent, that.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right, parent);
    }
}
