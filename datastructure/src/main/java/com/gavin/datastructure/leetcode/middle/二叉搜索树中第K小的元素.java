package com.gavin.datastructure.leetcode.middle;

import com.gavin.datastructure.leetcode.BinarylevelOrder;
import com.gavin.datastructure.leetcode.TreeNode;

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
class 二叉搜索树中第K小的元素 {
    List<Integer> arr = new ArrayList<>();

    private List<Integer> middleOrder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return arr;
        }
        middleOrder(root.left, arr);
        arr.add(root.val);
        middleOrder(root.right, arr);

        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = middleOrder(root, arr);
        return nums.get(k - 1);
    }

}
