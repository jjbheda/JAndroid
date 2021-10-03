package com.gavin;

import com.gavin.datastructure.leetcode.TreeNode;

class Tesstpinghe {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int LeftH = 0, rightH = 0;
       
        LeftH = height(root.left);
        rightH = height(root.right);

        if (LeftH == -1 || rightH == -1 || Math.abs(LeftH - rightH) > 1) {
            return -1;
        }

        return Math.max(LeftH , rightH) + 1;
    }
}
