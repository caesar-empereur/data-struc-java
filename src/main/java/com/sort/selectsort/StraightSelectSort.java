package com.sort.selectsort;

/**
 * Created by yang on 2020/9/22.
 */
public class StraightSelectSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = 10 - i;
        }
        for (int n : arr) {
            System.out.print(n + " 排序前\n");
        }
        straightSelectSort(arr);
        for (int n : arr) {
            System.out.print(n + " 排序后\n");
        }
    }

    /**
     *直接选择排序的思路是
     * 每一次从序列中找出最小的值放到最前面，
     * 第二次之后缩小序列，从中选出次小的值，放到序列第二个位置
     * 以后每一次都从逐渐缩小的序列中找出次小的值放到前面的排好序的子序列
     * 的最后位置, 不用排序, 因为每一次选出的值都会比上一次的大
     *
     */
    private static void straightSelectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 假设每一次第一个数是最小的
            int min = i;
            //这个循环就是为了找出i后面的最小的数的下标
            for (int j = i + 1; j < array.length; j++) {
                // 从 i 后面的数中找出最小的数的下标，放到 min 中
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                // 不相等说明后面有比 i 的数小的，与 i 交换
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }
}
