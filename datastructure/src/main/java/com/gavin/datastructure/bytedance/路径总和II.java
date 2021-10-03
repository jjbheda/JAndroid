package com.gavin.datastructure.bytedance;

import com.gavin.datastructure.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class 路径总和II {

    /**
     * 方法一：深度优先搜索
     * 思路及算法
     *
     * 我们可以采用深度优先搜索的方式，枚举每一条从根节点到叶子节点的路径。当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/path-sum-ii/solution/lu-jing-zong-he-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public void dfs(TreeNode root, int sum) {
       if (root == null) {
           return;
       }

       path.offerLast(root.val);
       sum -= root.val;
       if (root.left == null && root.right == null && sum ==0) {
           ret.add(new LinkedList<Integer>(path));
       }

       dfs(root.left, sum);
       dfs(root.right, sum);
       path.pollLast();
    }

}
