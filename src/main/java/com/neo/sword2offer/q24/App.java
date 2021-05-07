package com.neo.sword2offer.q24;

import com.neo.struct.ListNode;

public class App {

    public static void main(String[] args) {

        ListNode head = new ListNode("a");
        ListNode b = new ListNode("b");
        ListNode c = new ListNode("c");
        ListNode d = new ListNode("d");
        ListNode e = new ListNode("e");
        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Solution solution = new Solution();

        ListNode reserve = solution.reserve(head);

        System.out.println(1);
    }
}
