package com.gavin.datastructure.swordoffer;

import com.gavin.datastructure.leetcode.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class 链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++)
            former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }


    public ListNode getKthFromEnd2(ListNode head, int k) {
        // 获取链表的长度
        int size = size(head);

        if (size < k) {
            return null;
        }

        // 定义辅助指针
        ListNode temp = head;
        while (size != k && temp.next != null) {
            size --;
            temp = temp.next;
        }

        return temp;
    }
    //计算链表的长度
    public static int size(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            count ++ ;
            temp = temp.next;
        }

        return count;
    }


}
