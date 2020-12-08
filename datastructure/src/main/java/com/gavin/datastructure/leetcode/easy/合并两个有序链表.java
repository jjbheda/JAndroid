package com.gavin.datastructure.leetcode.easy;

import com.gavin.datastructure.leetcode.ListNode;

class 合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(0);

        while (l1 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
        }

        return temp;
    }
}

