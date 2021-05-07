package com.neo.leetcode.daily.q341;

import java.util.List;

public class NestedIntegerNode implements NestedInteger{

    private boolean isInteger;

    private Integer value;

    private List<NestedInteger> list;

    public NestedIntegerNode(boolean isInteger, Integer value, List<NestedInteger> list) {
        this.isInteger = isInteger;
        this.value = value;
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return isInteger;
    }

    @Override
    public Integer getInteger() {
        return value;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
