package com.gavin.datastructure.leetcode.easy;

import com.gavin.datastructure.leetcode.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 */
class 二叉树是否平衡 {
//  方法一：自底向上的递归

//    public boolean isBalanced(TreeNode root) {
//        return height(root) >= 0;
//    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }


    //方法二：自顶向下的递归  效率不高
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <=1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }



}
