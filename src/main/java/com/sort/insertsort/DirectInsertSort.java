package com.sort.insertsort;

/**
 * Created by yang on 2020/9/22.
 */
public class DirectInsertSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = 10 - i;
        }
        for (int n : arr) {
            System.out.print(n + " 排序前\n");
        }
        insertSort(arr);
        for (int n : arr) {
            System.out.print(n + " 排序后\n");
        }
    }

    /**
     * 从小到大排序
     *
     * 将0个记录组成有序子表，一次将后面的记录插入子表，并保持子表有序性
     */
    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //待插入的元素 先存放到一个地方
            int temp = array[i];
            int j = i - 1;
            //将待插入的元素前面的元素全部遍历比较
            while (j >= 0 && array[j] > temp) {
                /*
                只要子表里有元素比待插入的元素大，说明插入元素小
                子表里面从那个比插入元素大的地方全部后移动
                j 是插入元素的前面，每次移动子表，j减去1
                 */
                array[j + 1] = array[j];
                j--;
            }
            /*
             * 如果子表的元素全部都移动，则j变成0，相当于待插入元素
             要插入到子表的第一个位置
             */
            array[j + 1] = temp;
        }
    }
}
