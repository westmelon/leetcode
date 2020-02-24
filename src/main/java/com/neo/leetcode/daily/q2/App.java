package com.neo.leetcode.daily.q2;

public class App {

    public static void main(String[] args) {

        ListNode l1 = genListNode(9, 2, 3, 4, 5);
        ListNode l2 = genListNode(3, 2, 3, 4, 5);
        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        System.out.println(1);
    }

    private static ListNode genListNode(int... vals ){
        ListNode head = null;
        ListNode tail = null;
        ListNode temp;
        for (int val : vals ){
            if(head == null){
                head = new ListNode(val);
                tail = head;
            }else{
                temp = new ListNode(val);
                tail.next = temp;
                tail = temp;
            }
        }
        return head;

    }
}
