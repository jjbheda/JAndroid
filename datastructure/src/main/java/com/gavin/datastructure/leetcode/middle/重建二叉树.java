package com.gavin.datastructure.leetcode.middle;

import com.gavin.datastructure.leetcode.ListNode;
import com.gavin.datastructure.leetcode.TreeNode;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题思路：
 * 前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
 * 中序遍历性质： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序。
 *
 * 以题目示例为例：
 *
 * 前序遍历划分 [ 3 | 9 | 20 15 7 ]
 * 中序遍历划分 [ 9 | 3 | 15 20 7 ]
 * 根据以上性质，可得出以下推论：
 *
 * 最重要的思路
 * -----------------------------------------------------------------------------------------------
 * 前序遍历的首元素 为 树的根节点 node 的值。
 * 在中序遍历中搜索根节点 node 的索引 ，可将 中序遍历 划分为 [ 左子树 | 根节点 | 右子树 ] 。
 * 根据中序遍历中的左 / 右子树的节点数量，可将 前序遍历 划分为 [ 根节点 | 左子树 | 右子树 ] 。
 * -----------------------------------------------------------------------------------------------
 *
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class 重建二叉树 {

    HashMap<Integer ,Integer> indexMap = new HashMap();
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        for (int i = 0; i < in.length; i++) {
            indexMap.put(in[i], i);
        }

        // 注意这里的in 其实没用到，删掉也可以 。只有上面算索引时用到了
        return build(pre, 0, pre.length - 1 , in, 0, in.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = indexMap.get(rootVal);

        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }

}
