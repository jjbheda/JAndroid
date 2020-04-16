package com.gavin.datastructure.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 前K个高频元素 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,2,2,3,3,3,3,3,3,4,4,4,4,4,4,4,5};
        int k = 3;
        System.out.println(topKFrequent(nums, k));
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 按照 map 中元素的频率来创建List，频率相同的存入一个List中
        Map<Integer, List<Integer>> bucket = new HashMap<>();
        for (Integer key : map.keySet()) {
            // 频率为键，频率相同的元素存入同一个List中
            int i = map.get(key);
            List<Integer> list = bucket.get(i);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(key);
            bucket.put(i, list);
        }
        // 元素为整型的Set是有序的，因此倒序遍历
        Set<Integer> keySet = bucket.keySet();
        Integer[] array = keySet.toArray(new Integer[0]);
        for (int i = array.length - 1; i >= array.length - k && i >= 0 && result.size() < k; i--) {
            result.addAll(bucket.get(array[i]));
        }
        return result;
    }


}
