package com.gavin.datastructure.queue;

class TestRecursion {

    public static void main(String[] args) {
        test(4);
    }
    static void test(int i) {
        System.out.println("非递归的i=" + i);
        if (i > 0) {
            test(i - 2);
            System.out.println("第一层递归“i-2”的i=" + i);
        }
    }
}
