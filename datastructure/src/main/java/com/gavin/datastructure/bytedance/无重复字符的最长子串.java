package com.gavin.datastructure.bytedance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class 无重复字符的最长子串 {

    public static void main(String[] args) {
        无重复字符的最长子串 test = new 无重复字符的最长子串();
        test.lengthOfLongestSubstring("abcabcbb");
    }

    // 滑动窗口  --- 更简洁
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;  // 注意这里都是从0 开始的
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                ans = Math.max(ans, j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i ++;
            }
        }
        return ans;
    }

    //滑动窗口  好理解
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // left 更新，注意要看重复的字符串出现在之前的哪个位置上.比如"abba"
                // 注意map保存的始终只有唯一的Char，不会重复，只是不断地更新这个Char对应的索引位置
                // 比如计算到最后一个a时，这个a已经出现在第一个位置上map.get(s.charAt(i)) + 1 = 2，而此时
                // left 实际已经移动到索引为2的位置
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    //滑动窗口
    public int lengthOfLongestSubstring3(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
