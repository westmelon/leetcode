package com.neo.sword2offer.q25;

import com.neo.struct.ListNode;

import java.util.List;

public class App {


    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        ListNode list13 = new ListNode(3);
        ListNode list15 = new ListNode(5);
        ListNode list17 = new ListNode(7);
        list1.next = list13;
        list13.next = list15;
        list13.next = list17;

        ListNode list2 = new ListNode(2);
        ListNode list24 = new ListNode(4);
        ListNode list26 = new ListNode(6);
        ListNode list28 = new ListNode(8);

        list2.next = list24;
        list24.next = list26;
        list26.next = list28;

        Solution solution = new Solution();
        ListNode merge = solution.merge(list1, list2);
        System.out.println(1);

    }
}
