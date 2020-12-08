package com.gavin.datastructure.swordoffer;

import com.gavin.datastructure.leetcode.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class 对称的二叉树 {
    /**
     * 递归法
     * 递归三部曲
     * 确定递归函数的参数和返回值
     * 因为我们要比较的是根节点的两个子树是否是相互翻转的，进而判断这个树是不是对称树，所以要比较的是两个树，参数自然也是左子树节点和右子树节点。
     *
     * 返回值自然是bool类型。
     *
     * 代码如下：
     *
     *
     * bool compare(TreeNode* left, TreeNode* right)
     * 确定终止条件
     * 要比较两个节点数值相不相同，首先要把两个节点为空的情况弄清楚！否则后面比较数值的时候就会操作空指针了。
     *
     * 节点为空的情况有：（注意我们比较的其实不是左孩子和右孩子，所以如下我称之为左节点右节点）
     *
     * 左节点为空，右节点不为空，不对称，return false
     * 左不为空，右为空，不对称 return false
     * 左右都为空，对称，返回true
     * 此时已经排除掉了节点为空的情况，那么剩下的就是左右节点不为空：
     *
     * 左右都不为空，比较节点数值，不相同就return false
     * 此时左右节点不为空，且数值也不相同的情况我们也处理了。
     *
     * 代码如下：
     *
     *
     * if (left == NULL && right != NULL) return false;
     * else if (left != NULL && right == NULL) return false;
     * else if (left == NULL && right == NULL) return true;
     * else if (left->val != right->val) return false; // 注意这里我没有使用else
     * 注意上面最后一种情况，我没有使用else，而是elseif， 因为我们把以上情况都排除之后，剩下的就是 左右节点都不为空，且数值相同的情况。
     *
     * 确定单层递归的逻辑
     * 此时才进入单层递归的逻辑，单层递归的逻辑就是处理 右节点都不为空，且数值相同的情况。
     *
     * 比较二叉树外侧是否对称：传入的是左节点的左孩子，右节点的右孩子。
     * 比较内测是否对称，传入左节点的右孩子，右节点的左孩子。
     * 如果左右都对称就返回true ，有一侧不对称就返回false 。
     * 代码如下：
     *
     *
     * bool outside = compare(left->left, right->right);   // 左子树：左、 右子树：右
     * bool inside = compare(left->right, right->left);    // 左子树：右、 右子树：左
     * bool isSame = outside && inside;                    // 左子树：中、 右子树：中（逻辑处理）
     * return isSame;
     * 如上代码中，我们可以看出使用的遍历方式，左子树左右中，右子树右左中，所以我把这个遍历顺序也称之为“后序遍历”（尽管不是严格的后序遍历）。
     *
     *
     *
     * 作者：carlsun-2
     * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/solution/dui-cheng-er-cha-shu-di-gui-fa-die-dai-fa-xiang-ji/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
