package com.gavin.datastructure.leetcode.middle;

import com.gavin.datastructure.leetcode.ListNode;
import com.gavin.datastructure.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 *
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 *
 * 示例2:
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 *
 *
 * 示例3:
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-pruning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
class 二叉树剪枝 {
    public static void main(String[] args) {
        二叉树剪枝 test = new 二叉树剪枝();
        System.out.println(test.levelOrderBottom(test.pruneTree()));
    }
    public TreeNode pruneTree() {
        TreeNode root = buildTree();
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        if (!a1) node.left = null;
        if (!a2) node.right = null;
        return node.val == 1 || a1 || a2;
    }


    public TreeNode buildTree() {
        TreeNode root = new TreeNode(1);

        TreeNode root_1left = new TreeNode(0);
        TreeNode root_1left_left = new TreeNode(0);
        TreeNode root_1left_right = new TreeNode(0);
        TreeNode root_1right = new TreeNode(1);
        TreeNode root_1right_left = new TreeNode(0);
        TreeNode root_1right_right = new TreeNode(1);

        root.left = root_1left;
        root.right = root_1right;

        root_1left.left = root_1left_left;
        root_1left.right = root_1left_right;

        root_1right.left = root_1right_left;
        root_1right.right = root_1right_right;

        return root;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        //用来存放最终结果
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();

        //创建一个队列，将根节点放入其中
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> temp = new ArrayList<>();

            for (int i = 0;i <size;i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }
        //翻转最终结果并返回
        Collections.reverse(res);
        return res;
    }
}
