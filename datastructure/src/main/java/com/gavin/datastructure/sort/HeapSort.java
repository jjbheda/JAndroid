package com.gavin.datastructure.sort;

/**
 *  父节点与当前节点的下标对应关系为：
 *  当前节点下标为 I 则父节点的下标为（ I - 1）/2 = Parent ， 左孩子节点的下标为：2 * I+1= Lchild ,右节点的下标为：2 * I+2= Rchild 。
 *
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {5, 1, 7, 3, 1, 6, 9, 4};
        int[] arr = {16, 7, 3, 20, 17, 8};

        heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 堆排序
     */

    public static void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length -1 ) / 2; i >= 0; i --) {
            //构造初始堆，从第一个非叶子节点从下至上，从右至左调整结构
            adjustHeap(arr, i , arr.length);
        }

        //调整堆结构 + 交换堆顶元素与末尾元素
        for (int i = arr.length -1 ; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0 , i);
        }
    }

    /**
     * 调整堆
     */
    private static void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];

        //左孩子
        int lChild = 2 * parent + 1;
        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            //如果有右孩子节点，且右孩子节点的值大于左孩子节点，则选取右孩子节点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild ++;
            }
            //如果父节点的值已经大于孩子节点的值，则直接结束
            if (temp > arr[lChild]) {
                break;
            }

            //把孩子节点的值赋给父节点
            arr[parent] = arr[lChild];

            //选取孩子节点的左孩子节点，继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }

}
