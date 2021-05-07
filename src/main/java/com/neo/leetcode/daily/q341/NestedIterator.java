package com.neo.leetcode.daily.q341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class NestedIterator implements Iterator<Integer> {

    Iterator<NestedInteger> iterator;

    //保存上层迭代器的列表
    LinkedList<Iterator<NestedInteger>> temp = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        this.iterator = nestedList.iterator();
    }

    @Override
    public Integer next() {
        NestedInteger next = this.iterator.next();
        boolean isInteger = next.isInteger();
        if (isInteger) {
            //是数字直接返回
            return next.getInteger();
        } else {
            //是数组遍历数组
            List<NestedInteger> nextList = next.getList();
            //保存上层数组,替换当前数组为子数组
            temp.addLast(this.iterator);
            this.iterator = nextList.iterator();
            if(hasNext()) {
                return next();
            }
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        //当前节点是否还有下一个元素
        boolean current = this.iterator.hasNext();
        if (!current) {
            //判断上层是否有剩余元素
            while (temp.size() > 0) {
                //上层元素还有未遍历的
                Iterator<NestedInteger> last = temp.removeLast();
                if (last.hasNext()) {
                    this.iterator = last;
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */