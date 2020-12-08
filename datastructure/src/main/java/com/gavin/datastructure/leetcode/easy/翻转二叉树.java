package com.gavin.datastructure.leetcode.easy;

import com.gavin.datastructure.leetcode.ListNode;
import com.gavin.datastructure.leetcode.TreeNode;

import java.util.LinkedList;

/**
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p >
 *         4
 *     /     \
 *    2         7
 *   /   \     / \
 *  1     3   6   9
 * 输出：
 * <p>
 *           4
 *       /     \
 *      7       2
 *     / \     / \
 *    9   6   3   1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class 翻转二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(7);

        TreeNode left1_left = new TreeNode(1);
        TreeNode left1_right = new TreeNode(3);

        TreeNode right1_left = new TreeNode(6);
        TreeNode right1_right = new TreeNode(9);
        root.left = left1;
        root.right = right1;

        left1.left = left1_left;
        left1.right = left1_right;

        right1.left = right1_left;
        right1.right = right1_right;

        invertTree(root);
//        listBinary(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    // 二叉树的层次遍历
    public static void listBinary(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode currentNode;
        while (!list.isEmpty()) {
            currentNode = list.poll();
            System.out.println(currentNode.val);
            if (currentNode.left != null) {
                list.add(currentNode.left);
            }
            if (currentNode.right != null) {
                list.add(currentNode.right);
            }
        }
    }
}
