package com.gavin.datastructure.bytedance;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class TTT {
//    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);//入栈
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
////        System.out.println(stack.size());//栈中含有的元素  5
////        System.out.println(stack.search(2));//返回从栈
//
//        while (stack != null && stack.peek() != null) {
//            System.out.println(stack.pop());
//        }
//
//    }

    public static void main(String[] args) {
        int [] pushA = {1,2,3,4,5};
//        boolean s = IsPopOrder();
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack();

        for(int i = 0; i < pushA.length; i ++) {
            stack.add(pushA[i]);
        }
        int size = stack.size();
        for(int i = 0; i < size; i ++) {
            if (popA[i] != (Integer)stack.pop()) {
                return false;
            }
        }
        return true;
    }

}
