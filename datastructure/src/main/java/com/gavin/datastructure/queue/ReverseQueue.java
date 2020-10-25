package com.gavin.datastructure.queue;

class ReverseQueue {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

//        printList(node);
        ListNode reverseNode = reverse2(node);
        printList(reverseNode);
    }

    //测试方便的打印函数
    public static void printList(ListNode node){
        while (node != null){
            System.out.print(node.val);
            System.out.print(" ");
            node = node.next;
        }
        System.out.println();
    }
    //递归方式
    public static ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode temp = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return temp;
    }

    // 非递归方式

    /**
     * 我们可以申请两个指针，第一个指针叫 pre，最初是指向 null 的。
     * 第二个指针 cur 指向 head，然后不断遍历 cur。
     * 每次迭代到 cur，都将 cur 的 next 指向 pre，然后 pre 和 cur 前进一位。
     * 都迭代完了(cur 变成 null 了)，pre 就是最后一个节点了。
     *
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     * 来源：力扣（LeetCode）
     * @return
     */
    public static ListNode reverse2(ListNode list){
        ListNode current = list; // 定义 current 为当前链表
        ListNode pre = null;   // 定义 afterReverse 为转换之后的新链表,初始为 null
        // 当前链表不为空,进行反转操作
        while (current != null){
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}