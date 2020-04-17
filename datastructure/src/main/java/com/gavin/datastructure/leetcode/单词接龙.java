package com.gavin.datastructure.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 题解：
 * 我们将问题抽象在一个无向无权图中，每个单词作为节点，差距只有一个字母的两个单词之间连一条边。问题变成找到从起点到终点的最短路径，如果存在的话。因此可以使用广度优先搜索方法。
 *
 * 算法中最重要的步骤是找出相邻的节点，也就是只差一个字母的两个单词。为了快速的找到这些相邻节点，我们对给定的 wordList 做一个预处理，将单词中的某个字母用 * 代替。这个预处理帮我们构造了一个单词变换的通用状态。例如：Dog ----> D*g <---- Dig，Dog 和 Dig 都指向了一个通用状态 D*g。
 *
 * 这步预处理找出了单词表中所有单词改变某个字母后的通用状态，并帮助我们更方便也更快的找到相邻节点。否则，对于每个单词我们需要遍历整个字母表查看是否存在一个单词与它相差一个字母，这将花费很多时间。预处理操作在广度优先搜索之前高效的建立了邻接表。
 *
 * 例如，在广搜时我们需要访问 Dug 的所有邻接点，我们可以先生成 Dug 的所有通用状态：
 *
 * Dug => *ug
 * Dug => D*g
 * Dug => Du*
 * 第二个变换 D*g 可以同时映射到 Dog 或者 Dig，因为他们都有相同的通用状态。拥有相同的通用状态意味着两个单词只相差一个字母，他们的节点是相连的。
 *
 *利用广度优先搜索搜索从 beginWord 到 endWord 的路径。
 *
 * 算法
 *
 * 对给定的 wordList 做预处理，找出所有的通用状态。将通用状态记录在字典中，键是通用状态，值是所有具有通用状态的单词。
 *
 * 将包含 beginWord 和 1 的元组放入队列中，1 代表节点的层次。我们需要返回 endWord 的层次也就是从 beginWord 出发的最短距离。
 *
 * 为了防止出现环，使用访问数组记录。
 *
 * 当队列中有元素的时候，取出第一个元素，记为 current_word。
 *
 * 找到 current_word 的所有通用状态，并检查这些通用状态是否存在其它单词的映射，这一步通过检查 all_combo_dict 来实现。
 *
 * 从 all_combo_dict 获得的所有单词，都和 current_word 共有一个通用状态，所以都和 current_word 相连，因此将他们加入到队列中。
 *
 * 对于新获得的所有单词，向队列中加入元素 (word, level + 1) 其中 level 是 current_word 的层次。
 *
 * 最终当你到达期望的单词，对应的层次就是最短变换序列的长度。
 *
 * 标准广度优先搜索的终止条件就是找到结束单词。
 *
 * JavaPython
 *
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/word-ladder/solution/dan-ci-jie-long-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class 单词接龙 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] list = { "hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(list);
        System.out.println(ladderLength(beginWord, endWord, wordList));

    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        final Map<String, List<String>> allComboDict = new HashMap<String, List<String>>();

        for (String s : wordList) {
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = s.substring(0, i) + "*" + s.substring(i+1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                transformations.add(s);
                allComboDict.put(newWord, transformations);
            }
        }

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        List<String> visited = new ArrayList<>();
        visited.add(beginWord);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < L; i ++) {
                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.contains(adjacentWord)) {
                        visited.add(adjacentWord);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
         }
        return 0;
    }

}
