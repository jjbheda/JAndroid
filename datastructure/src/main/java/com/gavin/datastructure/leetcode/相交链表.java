package com.gavin.datastructure.leetcode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 如下面的两个链表：
 * <p>
 * <p>
 * <p>
 * 在节点 c1 开始相交。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


class 相交链表 {
    static ListNode headA, headB;

    public static void main(String[] args) {
        init();
       getIntersectionNode();
    }

    public static ListNode getIntersectionNode() {
        // 判空
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null

        while (pB.next != null) {
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                if (pA == pB) {
                    System.out.println(pA.val);
                    break;
                }
            }
            pB = pB.next;
        }
        return pA;

    }

    public static void init() {
        headA = new ListNode(4);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(8);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(5);

        headA.next = one;
        one.next = two;
        two.next = three;
        three.next = four;


        headB = new ListNode(5);
        ListNode one2 = new ListNode(0);
        ListNode two2 = new ListNode(1);
        ListNode three2 = new ListNode(8);
        ListNode four2 = new ListNode(4);
        ListNode five = new ListNode(5);

        headB.next = one2;
        one2.next = two2;
        two2.next = three2;
        three2.next = four2;
        four2.next = five;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
