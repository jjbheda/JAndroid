package com.gavin.datastructure.leetcode;

import com.gavin.datastructure.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BInaryTreeSmaller {
    private int i = 0;

    public TreeNode init() {
        TreeNode root = new TreeNode(3);

        TreeNode root_left_1 = new TreeNode(1);
        TreeNode root_right_1 = new TreeNode(4);

        root.left = root_left_1;
        root.right = root_right_1;

        TreeNode root_left_1_right = new TreeNode(2);
        root_left_1.right = root_left_1_right;
        return root;
    }


    public static void main(String args[]) {
        BInaryTreeSmaller bInaryTreeSmaller = new BInaryTreeSmaller();
        TreeNode root = bInaryTreeSmaller.init();
        // 中序遍历
        List<Integer> array = new ArrayList<>();
        int k = 1;
        int temp = 0;
        bInaryTreeSmaller.ldr(root, k, temp);
        System.out.println(temp);


    }

    public void ldr(TreeNode root, int k, int temp) {
        if (root == null) {
            return;
        }
        ldr(root.left, k, temp);
        if (k == ++i) {
            temp = root.val;
        }
        ldr(root.right, k, temp);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
