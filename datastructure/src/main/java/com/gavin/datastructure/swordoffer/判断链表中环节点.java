package com.gavin.datastructure.swordoffer;

import com.gavin.datastructure.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

class 判断链表中环节点 {
    public static void main(String[] args) {

    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null)
            return null;
        Set<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (set.contains(pHead)) {
                return pHead;
            } else {
                set.add(pHead);
                pHead = pHead.next;
            }
        }

        return null;
    }
}
