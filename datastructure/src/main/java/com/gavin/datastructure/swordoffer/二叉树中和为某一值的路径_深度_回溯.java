package com.gavin.datastructure.swordoffer;

import com.gavin.datastructure.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 本问题是典型的二叉树方案搜索问题，使用回溯法解决，其包含 先序遍历 + 路径记录 两部分
 *
 * 有个技巧是用sum 逐渐 减去 val 值，直到降为0
 *
 */
class 二叉树中和为某一值的路径_深度_回溯 {

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    void recur(TreeNode root, int tar) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        tar -= root.val;

        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<Integer>(path));
        }
        recur(root.left, tar);
        recur(root.right, tar);

        path.removeLast();  // 撤销 回到上一层 继续搜索

    }

}
