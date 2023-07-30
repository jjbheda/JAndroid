package com.gavin.datastructure.bytedance;

import com.gavin.datastructure.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class 二叉树的右视图 {
    // 层次遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    // 深度优先遍历   前序遍历的反向操作
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (depth == res.size()) {
            res.add(root.val);
        }

        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }


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



            if(root == null) {
                return;
            }
            childList.add(root.val);
            target -= root.val;

            if (target == 0 && root.left == null && root.right == null) {
                totolList.add(new LinkedList<Integer>(childList));
            }
            recur(root.left,target);
            recur(root.right,target);
            childList.removeLast();
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            ArrayList ans = new ArrayList<ArrayList<TreeNode>>();
            LinkedList<TreeNode> queue = new LinkedList();
            queue.offer(root);
            while (!queue.isEmpty()){
                LinkedList<Integer> levelList = new LinkedList<>();
                int size = queue.size(); //
                for (int i= 0;i < size;size++) {      //递归的逐次压入，每次for循环只处理当前层的，同时把下一层的压入队列
                    TreeNode curNode = (TreeNode) queue.poll();
                    levelList.offer(curNode.val);
                    if (curNode.left != null) {
                        queue.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                    }
                }
                ans.add(new LinkedList<Integer>(levelList));
            }
            return ans;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
