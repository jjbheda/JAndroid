package com.gavin.datastructure.bytedance;

import java.util.ArrayList;
import java.util.List;

class 括号生成 {

    public static void main(String[] args) {
        括号生成 test = new 括号生成();
        test.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    // 回溯   先生成左侧3个(,  再生成右侧3个)  然后逐步回溯 先回溯 右侧）  一直到左侧最后一个（，再回溯 （

    /**
     *
     * @param ans
     * @param cur
     * @param open  ( 个数
     * @param close ）个数
     * @param max
     */
      public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {  //递归的出口
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {  // 剪枝  这里 不是 close < n
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }

    }
}
