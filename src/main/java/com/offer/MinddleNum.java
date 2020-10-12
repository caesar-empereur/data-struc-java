package com.offer;

import java.util.PriorityQueue;

/**
 * @Description 找出数组的中位数
 * 中位数的概念
 * 1 3 5 7 9    中位数是 5
 * 1 3 5 7 9 10 中位数是 6
 * @author: yangyingyang
 * @date: 2020/10/12.
 */
public class MinddleNum {

    public static void main(String[] args) {

    }

    private static double findMinddleNum(int[] array) {
        //小顶堆，用来存放数组较大的数，放在右边
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //大顶堆，用来存放数组较小的数，放在左边
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int mindLenght = 0;
        if (array.length % 2 == 0){
            mindLenght = array.length / 2;
        } else {
            mindLenght = array.length / 2 + 1;
        }
        for (int i : array) {
            //默认放到大顶堆
            if (maxHeap.size() == 0 || i <= maxHeap.peek()){
                maxHeap.add(i);
                if (maxHeap.size() > mindLenght){
                    minHeap.add(maxHeap.poll());
                }
            } else {
                minHeap.add(i);
                if (maxHeap.size() < mindLenght){
                    maxHeap.add(minHeap.poll());
                }
            }
        }
        if (array.length % 2 == 0){
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
        return maxHeap.peek();
    }
}
