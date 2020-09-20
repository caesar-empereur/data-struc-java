package com.stackqueue;

/**
 * Created by yang on 2020/9/20.
 */
public class LinkQueue<T> {

    private Node<T> front, end;

    private int length;

    public LinkQueue() {
        length = 0;
        front = end = new Node<>(null, null);
    }

    /*
     入队
     */
    private void offer(T obj){
        //构造结点挂到队列尾部
        end.next = new Node(obj, null);
        //队列的尾部需要重新指向
        end = end.next;
        length++;
    }

    /*
    出队
     */
    private T poll(){
        T returnValue = front.value;
        front = front.next;
        length--;
        return returnValue;
    }

    /*
    获取队列头部元素
     */
    private T getHead(){
        return front.value;
    }

    /*
    遍历队列
     */
    private void access(){
        while (front != null){
            System.out.println(front.value);
            front = front.next;
        }
    }

    private static class Node<T>{
        private T value;
        private LinkQueue.Node next;

        public Node(T value, LinkQueue.Node next) {
            this.value = value;
            this.next = next;
        }

    }
}
