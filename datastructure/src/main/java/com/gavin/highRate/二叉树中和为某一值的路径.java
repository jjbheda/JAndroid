package com.gavin.highRate;

import com.gavin.datastructure.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class 二叉树中和为某一值的路径 {
    LinkedList<Integer> childList = new LinkedList<>();
    List<List<Integer>> totolList = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return totolList;
    }

    void recur(TreeNode root, int target) {
       if (root == null) {
           return;
       }
        childList.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            totolList.add(new LinkedList<Integer>(childList)) ;
        }
        recur(root.left, target);
        recur(root.right, target);
        childList.removeLast();
    }
}
