package com.gavin.datastructure.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,8,30,15,7],
 *
 *       3
 *    /    \
 *   9     20
 *  / \    /  \
 * 8  30  15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [8,30,15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinarylevelOrder {
    static List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public static void main(String args[]) {
        BinarylevelOrder binarylevelOrder = new BinarylevelOrder();
        TreeNode root = binarylevelOrder.init();

        binarylevelOrder.levelOrder(root);

        System.out.println(levels);


    }

    public TreeNode init() {
        TreeNode root = new TreeNode(3);

        TreeNode root_left_1 = new TreeNode(9);
        TreeNode root_right_1 = new TreeNode(20);

        root.left = root_left_1;
        root.right = root_right_1;

        TreeNode root_left_1_left = new TreeNode(8);
        TreeNode root_left_1_right = new TreeNode(30);

        root_left_1.left = root_left_1_left;
        root_left_1.right = root_left_1_right;

        TreeNode root_right_1_left = new TreeNode(15);
        TreeNode root_right_1_right = new TreeNode(7);

        root_right_1.left = root_right_1_left;
        root_right_1.right = root_right_1_right;

        return root;
    }

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        levels.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, level + 1);
        }

        if (node.right != null) {
            helper(node.right, level +1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

    public class TreeNode {
        int val;
       TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

