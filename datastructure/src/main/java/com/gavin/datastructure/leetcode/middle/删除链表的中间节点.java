package com.gavin.datastructure.leetcode.middle;

import com.gavin.datastructure.leetcode.ListNode;

class 删除链表的中间节点 {
   public ListNode deleteMiddle(ListNode head) {
      if (head.next == null) return null; // 边界情况。
      ListNode fast = head;
      ListNode slow = head;
      ListNode pre = null;

      while (fast != null && fast.next != null) { // 快指针不是尾节点时。
         fast = fast.next.next;
         pre = slow;
         slow = slow.next;
      }
      pre.next = pre.next.next;
      return head;
   }
}
