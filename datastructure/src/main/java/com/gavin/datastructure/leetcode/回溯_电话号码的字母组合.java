package com.gavin.datastructure.leetcode;
/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题思路
 * 本题是一个电话号码组合的问题，或者说是一个全排列问题。一般来说，我们需要使用回溯法来解决这个问题。
 *
 * 对于回溯法解题的套路框架，我建议大家可以去看
 *
 * labuladong的算法小抄
 *
 * labuladong这位大佬写的而非常详细，看了大佬的解题思路真的受益匪浅。（一定要看，墙裂推荐！）
 *
 * 那我们回溯法的解体框架是什么呢，解决一个回溯问题，实际上就是一个决策树的遍历过程。一般来说，我们需要解决三个问题：
 *
 * 路径：也就是已经做出的选择。
 * 选择列表：也就是你当前可以做的选择。
 * 结束条件：也就是到达决策树底层，无法再做选择的条件。
 * 我们所使用的框架基本就是：
 *
 * 其中最关键的点就是：在递归之前做选择，在递归之后撤销选择。
 *
 * LinkedList result = new LinkedList();
 * public void backtrack(路径，选择列表){
 *     if(满足结束条件){
 *         result.add(结果);
 *     }
 *     for(选择：选择列表){
 *         做出选择;
 *         backtrack(路径，选择列表);
 *         撤销选择;
 *     }
 * }
 * 对于本题来说，我们只需要将数字对应的字母映射到map当中，之后按照回溯的模板来写代码即可。
 *
 * 作者：ming-zhi-shan-you--m9RfkvKDad
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/17-dian-hua-hao-ma-de-zi-mu-zu-he-by-ming-zhi-shan/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 回溯_电话号码的字母组合 {
    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(letterCombinations("34"));

    }
    public static List<String> letterCombinations(String digits) {
        if(digits == null ||digits.length() == 0){
            return result;
        }
        HashMap<Character,char[]> map = new HashMap<>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        conbin(digits,0, new StringBuilder().append(""), map);
        return result;
    }

    public static void conbin(String digits, int depth, StringBuilder str,HashMap<Character,char[]> map) {
        if (depth == digits.length()) {
            result.add(str.toString());
            return ;
        }
        //选择列表
        char temp = digits.charAt(depth);
        char[] charArr = map.get(temp);
        for(int i = 0; i < charArr.length; i++) {
            //做出选择
            str.append(charArr[i]);
            conbin(digits,depth + 1, str, map);
            //撤销选择
            str.deleteCharAt(str.length() - 1);
        }
    }
}
