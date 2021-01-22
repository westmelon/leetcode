package com.neo.leetcode.daily.q24;


/**
 * @author linyi 2021-01-22
 */
public class Solution {


    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }


    private ListNode swap(ListNode node){
        if(node == null){
            return null;
        }
        ListNode next = node.next;
        if(next == null){
            return node;
        }
        ListNode sectionHead = swap(next.next);
        node.next = sectionHead;
        next.next = node;
        return next;
    }
}
