package com.neo.leetcode.q2;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = add(l1, l2);
        ListNode tail = head;
        while(l1.next != null || l2.next != null){
            ListNode added = add(l1.next, l2.next);
            append(tail, added);
            tail = added;
            l1 = l1.next == null ? new ListNode(0) : l1.next;
            l2 = l2.next == null ? new ListNode(0) : l2.next;
        }
        if(tail.val > 9){
            tail.val -= 10;
            tail.next = new ListNode(1);
        }
        return head;
    }

    private ListNode add(ListNode l1, ListNode l2){
        int tmp = 0;
        if(l1 != null && l2 != null){
            tmp = l1.val + l2.val;
        }else if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            tmp = l2.val;
        }else {
            tmp = l1.val;
        }
        return new ListNode(tmp);
    }

    private void append(ListNode front, ListNode next){
        if(front.val > 9){
            front.val -= 10;
            next.val ++;
        }
        front.next = next;
    }
}
