package com.gavin.datastructure.leetcode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class 合并两个有序链表 {
   static ListNode l1;
    static ListNode l2;
    static ListNode node;

    public static void main(String[] args) {
        init();

//        while(l1!= null) {
//            System.out.println(l1.val);
//            l1 = l1.next;
//        }

        ListNode node =  mergeTwoLists2(l1,l2);
        while(node!= null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    //递归 方法
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
              return l2;
        }
    }

    // 迭代
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;            //这里是重点  prehead 相当于链表头 ，所以底部为prehead.next

       while(l1 != null && l2 != null) {
           if (l1.val < l2.val) {
               prev.next = l1;
               l1 = l1.next;
           } else {
               prev.next = l2;
               l2 = l2.next;
           }
           prev = prev.next;
       }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    public static void init() {
        l1 = new ListNode(1);
        ListNode one1 = new ListNode(2);
        ListNode two1 = new ListNode(4);

        l1.next = one1;
        one1.next = two1;

        l2 = new ListNode(1);
        ListNode one2 = new ListNode(3);
        ListNode two2 = new ListNode(4);

        l2.next = one2;
        one2.next = two2;
    }
}
