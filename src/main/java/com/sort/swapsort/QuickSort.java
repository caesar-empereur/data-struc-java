package com.sort.swapsort;

/**
 * Created by yang on 2020/9/22.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = 10 - i;
        }
        for (int n : arr) {
            System.out.print(n + " 排序前\n");
        }
        quickSort(arr);
        for (int n : arr) {
            System.out.print(n + " 排序后\n");
        }
    }

    private static void quickSort(int[] array) {
        quickSort(0, array.length - 1, array);
    }

    private static void quickSort(int low, int hight, int[] array) {
        if (low < hight) {
            int mid = quickSortPartition(low, hight, array);
            quickSort(low, mid - 1, array);
            quickSort(mid + 1, hight, array);
        }
    }

    private static int quickSortPartition(int i, int j, int[] array) {
        int base = array[j]; // 最右边的为基准值
        while (i < j) {
            while (i < j && array[i] < base) { // 从左边开始，如果比基准值小，就继续向右走
                i++;
            }
            if (i < j) { // 上面的while循环结束时，就说明当前的arr[i]的值比基准值大，应与基准值进行交换
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j--; // 每交换一次，右边的 j需要前移
            }
            while (i < j && array[j] > base) {// 这时基准值跑到左边,因此需要从右向前一次比较
                j--; // 从右边开始遍历，如果比基准值大，就继续向左走
            }
            if (i < j) { // 上面的while循环结束时，就说明当前的arr[j]的值比基准值小，应与基准值进行交换
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        return j;
    }
}
