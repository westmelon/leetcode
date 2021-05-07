package com.neo.sword2offer.q25;

import com.neo.struct.ListNode;

public class Solution {


    public ListNode merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        ListNode head = null;
        if (list1 == null || list2.intValue < list1.intValue) {
            //链表2头结点比链表1大
            head = list2;
            head.next = merge(list1, list2.next);

        } else if (list2 == null || list1.intValue < list2.intValue) {
            //链表1头结点比链表2大
            head = list1;
            head.next = merge(list1.next, list2);
        }
        return head;
    }
}
