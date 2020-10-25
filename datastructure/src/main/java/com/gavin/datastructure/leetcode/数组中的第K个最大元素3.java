package com.gavin.datastructure.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 通过 最大值堆的方式
 */
class 数组中的第K个最大元素3 {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        /*
         * 调用建立大顶堆方法：
         * index：传入最后一个非叶子节点，即list.size()/2-1;
         * */
        for (int i = list.size() / 2 - 1; i >= 0; i--) {
            buildHeap(list, i, list.size());
        }
        System.out.println("输出建立的大顶堆数值：");
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("对建立的大顶堆数值进行升序：");
        heapSort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        /*
         *
         * 删除大顶堆中数值索引方法：
         *
         */

        delete(list, 0);

// 使用迭代器的方式输出集合中的元素
        Iterator<Integer> iterator = list.iterator();
        System.out.println("删除数据后的大顶堆：");
        while (iterator.hasNext()) {
            Integer in = iterator.next();
            System.out.print(in + " ");
        }
    }

    // 方法：建立大顶堆
    /*	思路：
     * 		1) 从最后一个节点的父节点(list.size()/2-1)开始,向下调整，建立大顶堆;
     * 		2) 比较父节点与孩子节点的大小：
     * 			2.1  若父节点小于左节点，将左节点跟父节点交换，继续向下调整。
     * 			2.2  若父节点大于左节点，将左节点跟父节点交换，继续向下调整。
     * 参数：
     * 		index：表示最初传进来的索引
     * 		size:表示集合的大小
     *
     * */
    public static void buildHeap(List<Integer> list, int index, int size) {
        int leftchild = 2 * index + 1;
        int rightchild = 2 * index + 2;
        int temp = index;
        if (leftchild < size && list.get(index) < list.get(leftchild)) {
            index = leftchild;
        }
        if (rightchild < size && list.get(index) < list.get(rightchild)) {
            index = rightchild;
        }
        if (index != temp) {
            Collections.swap(list, temp, index);
            // 交换后继续向下调整,以index为父节点，继续向下调整
            buildHeap(list, index, size);
        }
    }

    /*
     * 堆排序：
     *		1)将已经建立好的大顶堆，每次取出根节点，即最大值。
     *		2)将最后一个节点的值赋给根节点，重新构建大顶堆。
     *		3)删除最后节点的数据
     * */
    public static void heapSort(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            Collections.swap(list, i, 0);
            // 从根节点向下调整，每次取出一个数值，集合长度逐渐减小
            buildHeap(list, 0, i);
        }
    }

    // 方法：得到要删除数据的索引
    public static int getIndex(List<Integer> list, int number) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number) {
                index = i;
                break;
            }
        }
        return index;
    }

    // 方法：删除大顶堆中的一个数据
    public static void delete(List<Integer> list, int index) {
        // 1.将最后一个节点，也即最后一个叶子节点的值(list.size()-1)赋给要删除数据的值
        list.set(index, list.get(list.size() - 1));
        // 2.下沉操作,即向下判断赋值之后的数值与其孩子值的大小，从此处向下判断
        heapdown(list, index);
        // 3.删除最后一个叶子节点
        list.remove(list.size() - 1);
    }

    /*
     *    下沉操作：
     *    	1) 判断重新赋值的索引处(index)与其孩子大小
     * */
    public static void heapdown(List<Integer> list, int index) {
        int child = 2 * index + 1;
        int length = list.size() - 1;
        while (child < length) {
            if (child + 1 < length && list.get(child) < list.get(child + 1)) {
                child++;
            }
            if (list.get(index) > list.get(child)) {
                break;
            } else {
                Collections.swap(list, child, index);
                heapdown(list, child);
            }
        }
    }
}
