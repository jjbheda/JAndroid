package com.gavin.datastructure.bytedance;

import com.gavin.datastructure.leetcode.TreeNode;

class 路径之和 {

    public static void main(String[] args) {

    }

    // 递归 ---》 主要思想是 要想到之和，可以逐级减去当前节点值，如果最后一个节点恰好与最后的减法结果相同，则满足
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
           return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val) ;
    }

    // 递归二  如果不通过减法，通过加法
    public boolean hasPathSum2(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    public boolean dfs(TreeNode root, int plus, int sum){
        if(root == null) return false;
        plus += root.val;
        if(plus == sum && root.left == null && root.right == null){
            return true;
        }
        return dfs(root.left,plus,sum) ||  dfs(root.right,plus,sum);
    }
}
