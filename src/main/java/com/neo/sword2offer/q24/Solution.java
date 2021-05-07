package com.neo.sword2offer.q24;

import com.neo.struct.ListNode;

import java.util.List;

public class Solution {

    //1. 2 3
    public ListNode reserve(ListNode head) {

        if (head == null) {
            return null;
        }

        //前驱节点
        ListNode prev = null;
        //后驱节点
        ListNode next = null;
        //当前节点
        ListNode node = head;
        ListNode result = null;
        while(node != null) {
            next = node.next;
            if(next == null){
                result = node;
            }

            //当前节点的后驱变为之前的前驱
            node.next = prev;
            //进入下一个循环前 缓存当前节点为下个节点的前驱
            prev = node;
            //处理下一个节点
            node = next;

        }

        return result;
    }
}
