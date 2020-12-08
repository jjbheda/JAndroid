package com.gavin.datastructure.sort;

class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {20, 40, 33, 50, 15, 12, 55, 42, 90};

        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void sort(int[] arr) {
      int initDex = arr.length / 2 + 1;



      for (int i  = 0; i < initDex; i ++) {
          if (arr[i] > arr[initDex] && (initDex + i + 1) < arr.length) {
              int temp =  arr[initDex + i + 1] ;
              arr[i] =  temp;
              arr[initDex + i + 1] =  arr[i];
          }
      }



    }
}
