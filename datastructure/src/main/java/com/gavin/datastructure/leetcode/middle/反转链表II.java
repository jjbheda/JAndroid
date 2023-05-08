package com.gavin.datastructure.leetcode.middle;

import com.gavin.datastructure.leetcode.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 */
public class 反转链表II {
    // 注意  给的2个整数是从1开始，不是从0开始
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;

        // 第1步 ： 从 虚拟头节点走 left - 1步，来到left 节点的前一个节点，注意pre 是从哑节点开始的
        for (int i = 0; i < left - 1 ; i++) {
            pre = pre.next;
        }

        // 第2步： 从pre 再走 right - left + 1步，来到right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第3步  切断出一个子链表(截取链表)   ，就是把pre.next  right.next 现场保存起来
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        //切断链接
        pre.next = null;
        rightNode.next = null;

        //第4步  翻转链表的子区间
        reverseLinkedList(leftNode);

        //第5步 接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null ) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

}
