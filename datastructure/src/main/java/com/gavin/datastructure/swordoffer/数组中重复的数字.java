package com.gavin.datastructure.swordoffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class 数组中重复的数字 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3, 5};
        System.out.println(findRepeatNumber(nums));
    }

    public static List<Integer> findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<>();
        int repeat = -1;
        for (int num : nums) {
            if (set.contains(num)) {
                list.add(num);
            } else {
                set.add(num);
            }
        }
        return list;
    }
}
