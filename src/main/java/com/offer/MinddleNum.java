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
        int[] array = new int[] { 2,5,7,8,4,9 };
        System.out.println(findMinddleNum(array));
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
            //默认放到左边的大顶堆 (用来存放数组较小的数)
            if (maxHeap.size() == 0 || i <= maxHeap.peek()){
                maxHeap.add(i);
                //如果大顶堆的个数已经比小顶堆的多
                if (maxHeap.size() > mindLenght){
                    //则把大顶堆的堆顶 转移到 小顶堆
                    minHeap.add(maxHeap.poll());
                }
            } else {
                minHeap.add(i);
                //如果小顶堆的个数 比大顶堆的个数多
                if (maxHeap.size() < mindLenght){
                    //则把小顶堆的堆顶转移到大顶堆
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
