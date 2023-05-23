package com.gavin.datastructure.swordoffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 链接：https://www.nowcoder.com/questionTerminal/435fb86331474282a3499955f0a41e8b
 *来源：牛客网
 * <p>
 * <p>
 *          1
 *       2     3
 *     4   8     5
 *   6
 *
 *   思路：  迭代遍历  压栈 至 最后一行，然后逐级弹栈 逐级计算 深度
 */
class 二叉树深度 {
    static TreeNode root;

    public static void main(String[] args) {
        init();
        System.out.println(TreeDepth2(root));
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public static int TreeDepth(TreeNode root) {

        if (root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 广度优先遍历
     * 一层一层遍历，最后计算层数
     */
    public static int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;

        while (!queue.isEmpty()) {
            System.out.println("-----" + ans + "层----");
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    System.out.println(node.left.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    System.out.println(node.right.val);
                }
                size--;
            }
            ans ++;
            System.out.println("+++++" + ans + "层+++++");
        }
        return ans;
    }


    private static void init() {
        root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(9);
        TreeNode left2_right_2 = new TreeNode(8);
        TreeNode left3 = new TreeNode(6);

        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(5);

        root.left = left1;
        root.right = right1;

        left1.left = left2;
        left1.right = left2_right_2;

        left2.left = left3;
        right1.right = right2;
    }

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}





