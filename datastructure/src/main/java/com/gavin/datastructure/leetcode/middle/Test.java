package com.gavin.datastructure.leetcode.middle;

import com.gavin.datastructure.Test06;
import com.gavin.datastructure.leetcode.ListNode;
import com.gavin.datastructure.leetcode.TreeNode;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Test {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        全排列 solution = new 全排列();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res)  {

        if (depth == len) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < len; i ++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, res);
                used[i] = false;
                path.remove(path.size() -1);
            }
        }
    }

    // 删除列表中倒数第N 个节点
    public ListNode remove(ListNode node, int n) {

        if (node == null) {
            return null;
        }
        ListNode head = new ListNode(-1);
        head.next = node;

        ListNode slow = node;
        ListNode fast = node;
        int i = 0;
        while (fast != null) {
            if (i < n) {
                fast = fast.next;
                i++;
            }
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode temp = slow.next;

        slow.next = temp.next;

        return head.next;
    }

    // 二叉树的右视图   广度优先遍历
    ArrayList<Integer> totalList = new ArrayList<>();
    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
           int size = queue.size();
           for (int i = 0; i < size; i ++) {
               TreeNode temp = queue.poll();
               if (temp.right != null) {
                   queue.offer(temp.right);
               }

               if (temp.left != null) {
                   queue.offer(temp.left);
               }
               if (i == size - 1) {
                   list.add(temp.val);
               }
           }
        }

    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (totalList.size() == depth) {
            totalList.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }

    public int getMaxRefit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i ++) {
            int diff = prices[i] - prices[i - 1]; //今天和昨天的差价
             if (diff > 0) {
                 profit += diff;
             }
        }
        return profit;
    }
}
