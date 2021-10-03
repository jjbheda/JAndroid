package com.gavin.datastructure.leetcode;

public class 翻转链表 {
    static class ListNode {
        int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);

        head.next = one;
        one.next = two;

        ListNode pre = reverseList2(head);

       while (pre != null) {
           System.out.println(pre.val);
           pre = pre.next;
       }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList2(head.next);
        head.next.next = head;      //执行到队列尾部后，将队尾的next 指向队列头
        head.next = null;           // 断开队列头的next
        return p;
    }


}
