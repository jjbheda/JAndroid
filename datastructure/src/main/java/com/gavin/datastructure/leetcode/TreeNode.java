package com.gavin.datastructure.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
         List<Integer> leafs = new ArrayList();
    }
    private static void test(TreeNode node, List<Integer> leafValues){

        if (node.left == null && node.right == null) {
            leafValues.add(node.val);
        }
        while (node.left != null) {
            test(node.left, leafValues);
        }

        while (node.right != null) {
            test(node.right, leafValues);
        }
    }

}
