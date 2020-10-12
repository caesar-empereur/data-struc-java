package com.book.sort.selectsort;

/**
 * Created by yang on 2020/9/23.
 */
public class HeapSort {

    public static void main(String[] args) {

    }

    /**
     * 堆排序
     */
    private static void heapSort(int[] array){
        int n = array.length;
        int temp;

        //创建小顶堆
        for (int i=n/2-1; i>=0;i--){
            adjustHeap(i, n, array);
        }
        //每一趟将小顶堆的顶拿出来依次从数组的后面往前面放，再调整堆
        for (int i=n-1;i>0; i--){
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            adjustHeap(0, i, array);
        }
    }

    /**
     * 调整小顶堆的过程
     */
    private static void adjustHeap(int low, int high, int[] array) {
        // i 是根结点在数组的下标
        int i = low;
        // j 是 i结点的左子结点
        int j = i * 2 + 1;
        // temp 是根结点的值
        int temp = array[i];
        while (j < high) {
            // j+1 是i结点的右子结点
            if (j < high - 1 && array[j] > array[j + 1]) {
                // 取出 i 结点的2个子结点中较小的那个
                j++;
            }
            if (array[j] < temp) {
                //如果根结点比2个子结点都大，子结点中小的那个往上移，成为根结点
                array[i] = array[j];
                //这时新的根结点i的下标是 2个子结点中小的那个的下标
                i = j;
                //j 是新的根结点i的左子结点
                j = i * 2 + 1;
            }
            else {
                break;
            }
        }
        //原来的根结点的值放到新的根结点的去，相当于根结点与一个子结点位置互换
        array[i] = temp;
    }
}
