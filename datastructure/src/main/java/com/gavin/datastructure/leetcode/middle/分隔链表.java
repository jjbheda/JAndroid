package com.gavin.datastructure.leetcode.middle;

import com.gavin.datastructure.leetcode.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *  
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

class 分隔链表 {

    /**
     * 双指针法：
     * 直觉
     *
     * 我们可以用两个指针before 和 after 来追踪上述的两个链表。两个指针可以用于分别创建两个链表，然后将这两个链表连接即可获得所需的链表。
     *
     * 算法
     *
     * 初始化两个指针 before 和 after。在实现中，我们将两个指针初始化为哑 ListNode。这有助于减少条件判断。（不信的话，你可以试着写一个不带哑结点的方法自己看看！）
     *
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/partition-list/solution/fen-ge-lian-biao-by-leetcode/
     *
     */

    // 关于哑点  ---》 相当于留在原地的一个指针   当起始指针不断移动，想要回到链表头，就可以用哑点 -> next 的方式，重新指向链表头
    public ListNode partition(ListNode head, int x) {
        //声明两个虚拟头结点
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);
        //声明两个移动的头结点，我们就都叫他们为当前节点cur1，cur2吧
        ListNode cur1 = dummyHead1;
        ListNode cur2 = dummyHead2;
        //依次判断链表中的每个值
        while(head != null) {
            //将小于x的值放在dummyHead1中，大于x的值放在dummyHead2中
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        //将第一个链表接在第二个链表后边
        cur1.next = dummyHead2.next;
        //将第二个链表尾部指向null
        cur2.next = null;
        return dummyHead1.next;
    }
}


