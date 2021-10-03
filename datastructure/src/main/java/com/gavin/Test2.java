package com.gavin;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Test2 {

    public static void main(String[] args) {
         int[] arr = {22, 6, 22, 3, 9, 34, 27, 18, 28, 87, 12, 33};
        qsort(0, arr.length - 1, arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer ,Integer> occs = new HashMap();
        for (int num : nums) {
            occs.put(num, occs.getOrDefault(num, 1));
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }

        });

        for (Map.Entry<Integer, Integer> entry : occs.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                int topNum = queue.peek()[1];

                if (topNum < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }

            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        return ret;

    }

    public static void qsort( int start, int end, int[] arr) {
        int pivot = arr[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && arr[j] > pivot) {
                j --;
            }

            while (i < j && arr[i] < arr[j]) {
                i ++;
            }

            if (i < j && arr[i] == arr[j] ) {
                i ++;
            } else {
                swap(arr, i, j);
            }

        }
        if ( i - 1 > start) qsort( start, i - 1, arr);
        if (j + 1 < end)  qsort( j + 1, end, arr);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
