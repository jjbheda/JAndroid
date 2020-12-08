package com.gavin.datastructure.leetcode.middle;

import com.gavin.datastructure.leetcode.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class 删除链表的倒数第N个节点 {

    /**
     * 方法一：计算链表长度
     * 思路与算法
     *
     * 一种容易想到的方法是，我们首先从头节点开始对链表进行一次遍历，得到链表的长度 LL。随后我们再从头节点开始对链表进行一次遍历，当遍历到第 L-n+1L−n+1 个节点时，它就是我们需要删除的节点。
     *
     * 为了与题目中的 nn 保持一致，节点的编号从 11 开始，头节点为编号 11 的节点。
     *
     * 为了方便删除操作，我们可以从哑节点开始遍历 L-n+1L−n+1 个节点。当遍历到第 L-n+1L−n+1 个节点时，它的下一个节点就是我们需要删除的节点，这样我们只需要修改一次指针，就能完成删除操作。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        删除链表的倒数第N个节点 test = new 删除链表的倒数第N个节点();
        ListNode head = test.buildListNode();
        test.removeNthFromEnd2(head,2);

        System.out.println(head);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);

        ListNode cur = dummy;

        for (int i = 0; i < length - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while( head!= null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    /**
     * 方法二：栈
     * 思路与算法
     *
     * 我们也可以在遍历链表的同时将所有节点依次入栈。根据栈「先进后出」的原则，我们弹出栈的第 nn 个节点就是需要删除的节点，并且目前栈顶的节点就是待删除节点的前驱节点。这样一来，删除操作就变得十分方便了。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();

        ListNode cur = dummy;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; ++i) {
            stack.pop();
        }

        ListNode prev = stack.peek();
        prev.next = prev.next.next;

        ListNode ans = dummy.next;
        return ans;
    }
    
    public ListNode buildListNode() {
        ListNode root = new ListNode(1);
        ListNode l_02 = new ListNode(2);
        ListNode l_03 = new ListNode(3);
        ListNode l_04 = new ListNode(4);
        ListNode l_05 = new ListNode(5);

        root.next = l_02;
        l_02.next = l_03;
        l_03.next = l_04;
        l_04.next = l_05;

        return root;
    }

}